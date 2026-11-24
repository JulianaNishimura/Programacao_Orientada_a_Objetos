package org.example.practiceExams.exam04.persistence;

public class CustomerDaoImpl {
import org.example.practiceExams.exam04.customer.CustomerDao;
import org.example.practiceExams.exam04.customer.CustomerDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(CustomerDto dto) {
        String sql = """
            INSERT INTO customer (plate, phone, vehicleType)
            VALUES (?, ?, ?)""";

        try(final PreparedStatement preparedStatement = ConnectionFactory.createPreparedStatement(sql)) {
            preparedStatement.setString(1,dto.plate());
            preparedStatement.setString(2,dto.phone());
            preparedStatement.setString(3,dto.type());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<CustomerDto> findOne(String plate) {
        String sql = """
                SELECT * FROM customer WHERE plate = ?""";

        try(final PreparedStatement preparedStatement = ConnectionFactory.createPreparedStatement(sql)) {
            preparedStatement.setString(1,plate);
            final ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return Optional.of(new CustomerDto(
                        rs.getString("plate"),
                        rs.getString("phone"),
                        rs.getString("type")
                ));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}

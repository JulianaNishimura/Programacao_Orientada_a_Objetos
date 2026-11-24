package org.example.practiceExams.exam04.persistence;

import org.example.exams.exam02.persistence.DespesaDto;
import org.example.practiceExams.exam04.costs.PeriodCostDao;
import org.example.practiceExams.exam04.costs.PeriodCostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodCostDaoImpl implements PeriodCostDao {
    @Override
    public List<PeriodCostDto> findAll() {
        String sql = """
              SELECT hours, fee FROM period_cost""";

        List<PeriodCostDto> result = new ArrayList<>();
        try(final PreparedStatement preparedStatement = ConnectionFactory.createPreparedStatement(sql)) {
            final ResultSet rs =  preparedStatement.executeQuery();
            while(rs.next()){
                result.add(new PeriodCostDto(
                        rs.getInt(1),
                        rs.getDouble(2)
                ));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }
}

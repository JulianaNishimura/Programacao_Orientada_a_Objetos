package org.example.exams.exam02.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDespesaDao implements DespesaDao{
    @Override
    public void salvar(DespesaDto despesa) {
        String sql = """
                INSERT INTO despesa (
                      id,
                      valor,
                      nome,
                      cnpj,
                      info,
                      tipo,
                      declaracao_id)
                VALUES (?, ?, ?, ?, ?, ?, ?)""";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, despesa.id());
            stmt.setDouble(2, despesa.valor());
            stmt.setString(3, despesa.nome());
            stmt.setString(4, despesa.cnpj());
            stmt.setString(5, despesa.info());
            stmt.setString(6, despesa.tipo());
            stmt.setInt(7, despesa.declaracaoId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DespesaDto> buscarTodosPorDeclaracao(int id) {
        List<DespesaDto> result = new ArrayList<>();
        String sql = "SELECT * FROM despesa WHERE declaracao_id = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            final ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new DespesaDto(
                        rs.getInt("id"),
                        rs.getDouble("valor"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("info"),
                        rs.getString("tipo"),
                        rs.getInt("declaracao_id")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void removerTodosPorDeclaracao(int id) {
        String sql = "DELETE FROM despesa WHERE declaracao_id = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

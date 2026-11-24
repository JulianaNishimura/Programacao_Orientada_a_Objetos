package org.example.exams.exam02.persistence;

import model.Declaracao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcDeclaracaoDao implements DeclaracaoDao{

    /*
    id INTEGER PRIMARY KEY,
                    ganho_tributavel NUMERIC NOT NULL,
                    valor_ja_pago NUMERIC NOT NULL
     */
    @Override
    public void salvar(DeclaracaoDto declaracao) {
        String sql = """
            INSERT INTO declaracao (id, tipo, ganho_tributavel, valor_ja_pago)
            VALUES (?, ?, ?, ?)""";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, declaracao.id());
            stmt.setString(2, declaracao.tipo());
            stmt.setDouble(3, declaracao.ganhoTributavel());
            stmt.setDouble(4, declaracao.valorPago());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(DeclaracaoDto declaracao) {
        String sql = "UPDATE declaracao SET ganho_tributavel = ?, valor_ja_pago = ? WHERE id = ?";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setDouble(1, declaracao.ganhoTributavel());
            stmt.setDouble(2, declaracao.valorPago());
            stmt.setInt(3, declaracao.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remover(DeclaracaoDto declaracao) {
        String sql = "DELETE FROM declaracao WHERE id = ?";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, declaracao.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<DeclaracaoDto> buscarPorId(int id) {
        String sql = "SELECT * FROM declaracao WHERE id = ?";

        try(final PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            final ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return Optional.of(new DeclaracaoDto(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getDouble("ganho_tributavel"),
                        rs.getDouble("valor_ja_pago")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}

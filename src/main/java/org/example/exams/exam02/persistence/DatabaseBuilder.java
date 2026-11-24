package org.example.exams.exam02.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {

    static void main() {
        final DatabaseBuilder builder = new DatabaseBuilder();
        builder.createTables();
    }

    public void createTables(){
        String sqlDeclaracao = """
                CREATE TABLE declaracao (
                    id INTEGER PRIMARY KEY,
                    ganho_tributavel NUMERIC NOT NULL,
                    valor_ja_pago NUMERIC NOT NULL,
                    tipo TEXT NOT NULL
                )
                """;
        String sqlDespesa = """
                CREATE TABLE despesa (
                  id INTEGER PRIMARY KEY,
                  valor NUMERIC NOT NULL,
                  nome TEXT NOT NULL,
                  cnpj TEXT NOT NULL,
                  info TEXT NOT NULL,
                  tipo TEXT NOT NULL,
                  declaracao_id INTEGER NOT NULL,

                  FOREIGN KEY (declaracao_id)
                      REFERENCES declaracao(id)
                )
                """;
        try(final Connection cnn = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement stmt = cnn.createStatement();
        ) {
            stmt.executeUpdate(sqlDeclaracao);
            stmt.executeUpdate(sqlDespesa);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

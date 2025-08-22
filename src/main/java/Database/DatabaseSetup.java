package Database;
import util.Factory;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void initDatabase() {
        try (Connection conn = Factory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS clientes (" +
                    "id_cliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "cpf TEXT UNIQUE NOT NULL," +
                    "telefone TEXT," +
                    "email TEXT)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS imoveis (" +
                    "id_imovel INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "endereco TEXT NOT NULL," +
                    "tipo TEXT NOT NULL," +
                    "quartos INTEGER," +
                    "banheiros INTEGER," +
                    "area REAL," +
                    "valor_aluguel REAL NOT NULL," +
                    "disponivel BOOLEAN DEFAULT 1)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS contratos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "id_cliente INTEGER NOT NULL," +
                    "id_imovel INTEGER NOT NULL," +
                    "valor REAL NOT NULL," +
                    "data_inicio DATE NOT NULL," +
                    "data_fim DATE NOT NULL," +
                    "ativo BOOLEAN DEFAULT 1," +
                    "FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)," +
                    "FOREIGN KEY (id_imovel) REFERENCES imoveis(id_imovel))");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package Database;

import java.sql.*;
import java.sql.Connection;

public class CreateSchema {
    public static void main(String[] args){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:imobiliaria.db");
             Statement statement = connection.createStatement();){
            statement.executeUpdate("CREATE TABLE clientes (\n" +
                    "                          id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "                          nome TEXT NOT NULL,\n" +
                    "                          cpf TEXT UNIQUE NOT NULL,\n" +
                    "                          telefone TEXT,\n" +
                    "                          email TEXT\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE imoveis (\n" +
                    "                         id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "                         endereco TEXT NOT NULL,\n" +
                    "                         tipo TEXT NOT NULL,\n" +
                    "                         quartos INTEGER,\n" +
                    "                         banheiros INTEGER,\n" +
                    "                         area REAL,\n" +
                    "                         valor_aluguel REAL NOT NULL,\n" +
                    "                         disponivel BOOLEAN DEFAULT 1\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE contratos (\n" +
                    "                           id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "                           id_cliente INTEGER NOT NULL,\n" +
                    "                           id_imovel INTEGER NOT NULL,\n" +
                    "                           valor REAL NOT NULL,\n" +
                    "                           data_inicio DATE NOT NULL,\n" +
                    "                           data_fim DATE NOT NULL,\n" +
                    "                           ativo BOOLEAN DEFAULT 1,\n" +
                    "                           FOREIGN KEY (id_cliente) REFERENCES clientes(id),\n" +
                    "                           FOREIGN KEY (id_imovel) REFERENCES imoveis(id)\n" +
                    ");");
            ResultSet rs = statement.executeQuery("select * from clientes");
            System.out.println("Criação do Banco Concluída com Sucesso!");
        }catch(SQLException e){
            e.printStackTrace(System.err);
        }
    }
}

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    public static final String url = "jdbc:sqlite:imobiliaria.db";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url);
        }
        catch (SQLException e){
            System.out.println("Erro ao conectar ao banco de dados.");
            throw new RuntimeException();
        }
    }
}

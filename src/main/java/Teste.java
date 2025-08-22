import Database.DatabaseSetup;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {
        DatabaseSetup.initDatabase();
    }
}

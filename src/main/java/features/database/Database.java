package features.database;

import features.settings.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    final static Database INSTANCE = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            String db_url = new Settings().getPref(Settings.DB_URL_KEY);
            return DriverManager.getConnection(db_url);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

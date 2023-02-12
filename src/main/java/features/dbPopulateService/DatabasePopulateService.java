package features.dbPopulateService;

import features.database.Database;
import features.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabasePopulateService {
    public static void main(String[] args) {
        String populate_sql = readSql(new Settings().getPref(Settings.POPULATE_SQL_KEY));

        if (populate_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(populate_sql)) {
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String readSql(String key) {
        try {
            return String.join("\n", Files.readAllLines(Path.of(key)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

package features.dbInitService;

import features.database.Database;
import features.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        String init_sql = readSql(new Settings().getPref(Settings.INIT_SQL_KEY));

        if (init_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(init_sql)) {
                ps.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String readSql(String url) {
        try {
            return String.join("\n", Files.readAllLines(Path.of(url)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

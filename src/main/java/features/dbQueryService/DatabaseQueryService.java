package features.dbQueryService;

import features.database.Database;
import features.dbQueryService.responses.*;
import features.settings.Settings;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Settings settings;

    public DatabaseQueryService() {
        this.settings = new Settings();
    }

    public List<LongestProject> find_longest_project() {
        List<LongestProject> projects = new ArrayList<>();
        String longest_sql = readSql(settings.getPref(Settings.LONGEST_SQL_KEY));

        if (longest_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(longest_sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("project_name");
                    float month = rs.getFloat("month_count");
                    projects.add(new LongestProject(id, name, month));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return projects;
    }

    public List<MaxClient> find_max_projects_client() {
        List<MaxClient> clients = new ArrayList<>();
        String clients_sql = readSql(settings.getPref(Settings.MAX_CLIENT_SQL_KEY));

        if (clients_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(clients_sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    int count = rs.getInt("project_count");
                    clients.add(new MaxClient(name, count));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return clients;
    }

    public List<MaxSalaryWorker> find_max_salary_worker() {
        List<MaxSalaryWorker> workers = new ArrayList<>();
        String workers_sql = readSql(settings.getPref(Settings.MAX_SALARY_SQL_KEY));

        if (workers_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(workers_sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");
                    workers.add(new MaxSalaryWorker(name, salary));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return workers;
    }

    public List<YoungOldWorker> find_youngest_eldest_workers() {
        List<YoungOldWorker> workers = new ArrayList<>();
        String workers_sql = readSql(settings.getPref(Settings.YOUNG_OLD_SQL_KEY));

        if (workers_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(workers_sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
                    workers.add(new YoungOldWorker(type, name, birthday));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return workers;
    }

    public List<Prices> print_project_prices() {
        List<Prices> prices = new ArrayList<>();
        String prices_sql = readSql(settings.getPref(Settings.PRICES_SQL_KEY));

        if (prices_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement ps = connection.prepareStatement(prices_sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String project = rs.getString("project_name");
                    BigDecimal price = rs.getBigDecimal("price");
                    prices.add(new Prices(project, price));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return prices;
    }


    private String readSql(String key) {
        try {
            return String.join("\n", Files.readAllLines(Path.of(key)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}

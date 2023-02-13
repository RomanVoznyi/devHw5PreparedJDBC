package features.dbPopulateService;

import features.database.Database;
import features.dbPopulateService.tables.Project;
import features.dbPopulateService.tables.Worker;
import features.settings.Settings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DatabasePopulateService {
    public static void main(String[] args) {
        populateWorker();
        populateClient();
        populateProject();
        populateProjWorker();
    }

    private static void populateWorker() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("John 1", LocalDate.parse("1985-10-05"), "Senior", 100000));
        workers.add(new Worker("John 2", LocalDate.parse("1986-10-05"), "Senior", 100000));
        workers.add(new Worker("John 3", LocalDate.parse("1985-10-05"), "Senior", 70000));
        workers.add(new Worker("John 4", LocalDate.parse("1988-11-05"), "Senior", 60000));
        workers.add(new Worker("John 5", LocalDate.parse("1989-11-05"), "Middle", 30000));
        workers.add(new Worker("John 6", LocalDate.parse("1990-11-05"), "Middle", 25000));
        workers.add(new Worker("John 7", LocalDate.parse("1995-12-05"), "Middle", 20000));
        workers.add(new Worker("John 8", LocalDate.parse("1996-12-05"), "Middle", 20000));
        workers.add(new Worker("John 9", LocalDate.parse("1997-12-05"), "Junior", 10000));
        workers.add(new Worker("John 10", LocalDate.parse("1998-08-05"), "Junior", 10000));
        workers.add(new Worker("John 11", LocalDate.parse("2000-08-05"), "Junior", 5000));
        workers.add(new Worker("John 12", LocalDate.parse("2000-09-05"), "Junior", 2000));
        workers.add(new Worker("John 13", LocalDate.parse("2001-10-05"), "Trainee", 1000));
        workers.add(new Worker("John 14", LocalDate.parse("2002-10-05"), "Trainee", 500));
        workers.add(new Worker("John 15", LocalDate.parse("2003-10-05"), "Trainee", 100));

        String populate_worker_sql = readSql(new Settings().getPref(Settings.POPULATE_WORKER_SQL_KEY));
        if (populate_worker_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement psWorker = connection.prepareStatement(populate_worker_sql)) {

                for (Worker worker : workers) {
                    psWorker.setString(1, worker.getName());
                    psWorker.setString(2, worker.getBirthday().toString());
                    psWorker.setString(3, worker.getLevel());
                    psWorker.setInt(4, worker.getSalary());
                    psWorker.execute();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void populateClient() {
        List<String> clients = Arrays.asList("Anna", "Bill", "Courtney", "Dilan", "Elon", "Fred", "George", "Helen");

        String populate_clients_sql = readSql(new Settings().getPref(Settings.POPULATE_CLIENT_SQL_KEY));
        if (populate_clients_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement psClient = connection.prepareStatement(populate_clients_sql)) {

                for (String client : clients) {
                    psClient.setString(1, client);
                    psClient.execute();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void populateProject() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1, "Project A", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-30")));
        projects.add(new Project(2, "Project B", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-02-15")));
        projects.add(new Project(3, "Project C", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-03-20")));
        projects.add(new Project(4, "Project D", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-04-25")));
        projects.add(new Project(5, "Project E", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-05-20")));
        projects.add(new Project(6, "Project F", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-06-15")));
        projects.add(new Project(7, "Project G", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-07-10")));
        projects.add(new Project(8, "Project H", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-08-05")));
        projects.add(new Project(1, "Project I", LocalDate.parse("2023-01-01"), LocalDate.parse("2024-01-10")));
        projects.add(new Project(1, "Project J", LocalDate.parse("2023-01-01"), LocalDate.parse("2031-01-01")));
        projects.add(new Project(8, "Project K", LocalDate.parse("2023-01-01"), LocalDate.parse("2023-02-15")));

        String populate_project_sql = readSql(new Settings().getPref(Settings.POPULATE_PROJECT_SQL_KEY));
        if (populate_project_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement psProject = connection.prepareStatement(populate_project_sql)) {

                for (Project project : projects) {
                    psProject.setInt(1, project.getClient_id());
                    psProject.setString(2, project.getName());
                    psProject.setString(3, project.getStart_date().toString());
                    psProject.setString(4, project.getFinish_date().toString());
                    psProject.execute();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void populateProjWorker() {
        int[][] pr_workers = new int[][]{{1, 1}, {2, 2}, {2, 15}, {3, 3}, {3, 5}, {3, 14}, {4, 4}, {4, 6},
                {4, 9}, {4, 13}, {5, 2}, {5, 7}, {6, 3}, {6, 8}, {7, 4}, {7, 8}, {7, 12}, {8, 1}, {8, 11},
                {9, 8}, {10, 1}, {10, 5}, {10, 6}, {10, 10}, {10, 11}, {11, 4}, {11, 10}};

        String populate_pr_worker_sql = readSql(new Settings().getPref(Settings.POPULATE_PR_WORKER_SQL_KEY));
        if (populate_pr_worker_sql != null) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement psPrWorker = connection.prepareStatement(populate_pr_worker_sql)) {

                for (int[] pair : pr_workers) {
                    psPrWorker.setInt(1, pair[0]);
                    psPrWorker.setInt(2, pair[1]);
                    psPrWorker.execute();
                }

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

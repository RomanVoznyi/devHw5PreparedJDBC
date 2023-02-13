package features.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Data
public class Settings {
    private Map<String,Object> settings;
    private static final String DEFAULT_SETTINGS_FILENAME = "prefs.json";
    public final static String DB_URL_KEY = "db_url";
    public final static String INIT_SQL_KEY = "init_sql";
    public final static String POPULATE_WORKER_SQL_KEY = "populate_worker_sql";
    public final static String POPULATE_CLIENT_SQL_KEY = "populate_client_sql";
    public final static String POPULATE_PROJECT_SQL_KEY = "populate_project_sql";
    public final static String POPULATE_PR_WORKER_SQL_KEY = "populate_pr_worker_sql";
    public final static String LONGEST_SQL_KEY = "f_longest_sql";
    public final static String MAX_CLIENT_SQL_KEY = "f_max_pr_client";
    public final static String MAX_SALARY_SQL_KEY = "f_max_salary";
    public final static String YOUNG_OLD_SQL_KEY = "f_young_old";
    public final static String PRICES_SQL_KEY = "f_prices";

    public Settings() {
        try {
            String prefs = String.join("\n", Files.readAllLines(Path.of(DEFAULT_SETTINGS_FILENAME)));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type mapType = new TypeToken<Map<String,Object>>(){}.getType();
            this.settings = gson.fromJson(prefs,mapType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPref(String key) {
      return settings.get(key).toString();
    }
}

package features.dbPopulateService.tables;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Worker {
    private int id;
    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

    public Worker(String name, LocalDate birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }
}

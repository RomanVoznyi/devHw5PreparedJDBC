package features.dbPopulateService.tables;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Project {
    private int id;
    private int client_id;
    private String name;
    private LocalDate start_date;
    private LocalDate finish_date;

    public Project(int client_id, String name, LocalDate start_date, LocalDate finish_date) {
        this.client_id = client_id;
        this.name = name;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }
}

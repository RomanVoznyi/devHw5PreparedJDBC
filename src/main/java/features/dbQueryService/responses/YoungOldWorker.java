package features.dbQueryService.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class YoungOldWorker {
    String type;
    String name;
    LocalDate birthday;

    public YoungOldWorker(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{type='" + type + "', worker='" + name + "', birthday='" + birthday + "'}";
    }
}

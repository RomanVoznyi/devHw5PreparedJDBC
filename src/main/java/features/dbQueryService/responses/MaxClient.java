package features.dbQueryService.responses;

import lombok.Data;

@Data
public class MaxClient {
    String name;
    int project_count;

    public MaxClient(String name, int project_count) {
        this.name = name;
        this.project_count = project_count;
    }

    @Override
    public String toString() {
        return "{client='" + name + "', projects='" + project_count + "'}";
    }
}

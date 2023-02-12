package features.dbQueryService.responses;

import lombok.Data;

@Data
public class MaxSalaryWorker {
    String name;
    int salary;

    public MaxSalaryWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{worker='" + name + "', salary='" + salary + "'}";
    }
}

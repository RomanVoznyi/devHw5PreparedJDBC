package features.dbQueryService.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Prices {
    String project_name;
    BigDecimal price;

    public Prices(String project_name, BigDecimal price) {
        this.project_name = project_name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{project='" + project_name + "', price=" + price + "'}";
    }
}

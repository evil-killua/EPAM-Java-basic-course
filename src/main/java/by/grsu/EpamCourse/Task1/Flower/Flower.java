package by.grsu.EpamCourse.Task1.Flower;

import java.math.BigDecimal;

public interface Flower {

    BigDecimal getPrice();
    FreshnessType getFreshness();
    int getStem();
    void setPrice(BigDecimal price);
    void setStem(int stem);
    void setFreshness(FreshnessType freshness);
}

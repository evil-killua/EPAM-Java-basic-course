package by.grsu.сourse.task1.flower;

import java.math.BigDecimal;

public interface Flower {

    BigDecimal getPrice();
    FreshnessType getFreshness();
    int getStem();
    void setPrice(BigDecimal price);
    void setStem(int stem);
    void setFreshness(FreshnessType freshness);
}

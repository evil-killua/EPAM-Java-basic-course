package by.grsu.EpamCourse.Task1.Flower.entity;

import by.grsu.EpamCourse.Task1.Flower.Flower;
import by.grsu.EpamCourse.Task1.Flower.FlowerTypes;
import by.grsu.EpamCourse.Task1.Flower.FreshnessType;

import java.math.BigDecimal;
import java.util.Objects;

public class TulipFlower implements Flower {

    private FlowerTypes name;
    private BigDecimal price;
    private int stem;
    private FreshnessType freshness;

    {
        name = FlowerTypes.Tulip;
    }

    public TulipFlower() {
    }

    public TulipFlower(BigDecimal price, int stem, FreshnessType freshness) {
        this.price = price;
        this.stem = stem;
        this.freshness = freshness;
    }

    public FlowerTypes getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStem(int stem) {
        this.stem = stem;
    }

    public void setFreshness(FreshnessType freshness) {
        this.freshness = freshness;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FreshnessType getFreshness() {
        return freshness;
    }

    public int getStem() {
        return stem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TulipFlower that = (TulipFlower) o;
        return stem == that.stem &&
                name == that.name &&
                Objects.equals(price, that.price) &&
                freshness == that.freshness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, stem, freshness);
    }

    @Override
    public String toString() {
        return "TulipFlower{" +
                "name=" + name +
                ", price=" + price +
                ", stem=" + stem +
                ", freshness=" + freshness +
                '}';
    }
}

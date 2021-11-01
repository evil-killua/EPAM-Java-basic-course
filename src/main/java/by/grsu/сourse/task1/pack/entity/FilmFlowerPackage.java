package by.grsu.сourse.task1.pack.entity;

import by.grsu.сourse.task1.pack.FlowerPackage;
import by.grsu.сourse.task1.pack.PackageType;

import java.math.BigDecimal;
import java.util.Objects;

public class FilmFlowerPackage implements FlowerPackage {

    private BigDecimal price;
    private PackageType type;

    {
        type = PackageType.Film;
    }

    public FilmFlowerPackage() {
    }

    public FilmFlowerPackage(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public PackageType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmFlowerPackage that = (FilmFlowerPackage) o;
        return Objects.equals(price, that.price) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, type);
    }

    @Override
    public String toString() {
        return "FilmPackage{" +
                "price=" + price +
                ", type=" + type +
                '}';
    }
}

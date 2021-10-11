package by.grsu.EpamCourse.Task1.Package.entity;

import by.grsu.EpamCourse.Task1.Package.FlowerPackage;
import by.grsu.EpamCourse.Task1.Package.PackageType;

import java.math.BigDecimal;
import java.util.Objects;

public class PaperFlowerPackage implements FlowerPackage {

    private BigDecimal price;
    private PackageType type;

    {
        type = PackageType.Paper;
    }

    public PaperFlowerPackage() {
    }

    public PaperFlowerPackage(BigDecimal price) {
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
        PaperFlowerPackage that = (PaperFlowerPackage) o;
        return Objects.equals(price, that.price) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, type);
    }

    @Override
    public String toString() {
        return "PaperPackage{" +
                "price=" + price +
                ", type=" + type +
                '}';
    }
}

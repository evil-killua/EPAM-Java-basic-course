package by.grsu.EpamCourse.Task1.Package;


import java.math.BigDecimal;

public interface FlowerPackage {

    BigDecimal getPrice();
    void setPrice(BigDecimal price);
    PackageType getType();

}

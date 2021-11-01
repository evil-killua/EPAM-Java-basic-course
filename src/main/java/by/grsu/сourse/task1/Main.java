package by.grsu.сourse.task1;

import by.grsu.сourse.task1.FlowerComposition;
import by.grsu.сourse.task1.flower.Flower;
import by.grsu.сourse.task1.flower.FlowerFactory;
import by.grsu.сourse.task1.flower.FlowerTypes;
import by.grsu.сourse.task1.flower.FreshnessType;
import by.grsu.сourse.task1.pack.FlowerPackage;
import by.grsu.сourse.task1.pack.FlowerPackageFactory;
import by.grsu.сourse.task1.pack.PackageType;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FlowerComposition flowerComposition = new FlowerComposition();

        List<Flower> flowers = getFlowers();
        FlowerPackage flowerPackage = getFlowerPackage();

        flowerComposition.setFlowerPackage(flowerPackage);
        flowerComposition.addFlowers(flowers);

        flowerComposition.sortByFreshness();

        flowerComposition.getFlowerByStemLength(20, 30);

    }

    public static FlowerPackage getFlowerPackage() {
        FlowerPackageFactory flowerPackageFactory = new FlowerPackageFactory();

        FlowerPackage flowerPackage = flowerPackageFactory.getFlowerPackage(PackageType.Paper);
        flowerPackage.setPrice(BigDecimal.valueOf(5));
        return flowerPackage;
    }

    public static List<Flower> getFlowers() {
        FlowerFactory flowerFactory = new FlowerFactory();
        List<Flower> flowers = new ArrayList<>();

        Flower rose = flowerFactory.getFlower(FlowerTypes.Rose);
        rose.setStem(40);
        rose.setPrice(BigDecimal.valueOf(10));
        rose.setFreshness(FreshnessType.Day_1);

        Flower chamomile = flowerFactory.getFlower(FlowerTypes.Chamomile);
        chamomile.setFreshness(FreshnessType.Day_3);
        chamomile.setPrice(BigDecimal.valueOf(8));
        chamomile.setStem(24);

        Flower chrysanthemum = flowerFactory.getFlower(FlowerTypes.Chrysanthemum);
        chrysanthemum.setStem(30);
        chrysanthemum.setPrice(BigDecimal.valueOf(12));
        chrysanthemum.setFreshness(FreshnessType.Day_2);

        Flower tulip = flowerFactory.getFlower(FlowerTypes.Tulip);
        tulip.setFreshness(FreshnessType.Day_4);
        tulip.setPrice(BigDecimal.valueOf(15));
        tulip.setStem(37);

        Collections.addAll(flowers,rose,chamomile,chrysanthemum,tulip);
        return flowers;
    }

}

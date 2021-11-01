package by.grsu.сourse.task1;

import by.grsu.сourse.task1.flower.Flower;
import by.grsu.сourse.task1.pack.FlowerPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlowerComposition {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlowerComposition.class);
    private List<Flower> flowers;
    private BigDecimal compositionPrice;
    private FlowerPackage flowerPackage;

    {
        flowers = new ArrayList<>();
        compositionPrice = new BigDecimal("0");
    }

    public FlowerComposition() {
    }

    public FlowerComposition(List<Flower> flowers, FlowerPackage flowerPackage) {
        this.flowers = flowers;
        this.flowerPackage = flowerPackage;

        for (Flower flower : flowers) {
            this.compositionPrice = this.compositionPrice.add(flower.getPrice());
        }
    }

    public List<Flower> sortByFreshness() {
        LOGGER.debug("sort list flowers by freshness");
        flowers.sort(Comparator.comparing(Flower::getFreshness));
        LOGGER.info("sorted list by freshness: {}", flowers);

        return flowers;
    }

    public List<Flower> getFlowerByStemLength(int from, int to) {
        List<Flower> flowerList = new ArrayList<>();
        LOGGER.debug("flower with stem length between {} and {}", from, to);

        for (Flower flower : flowers) {
            if (flower.getStem() >= from && flower.getStem() <= to) {
                flowerList.add(flower);
            }
        }

        if (flowerList.size() == 0) {
            LOGGER.warn("flower with stem between {} and {} not found", from, to);
            return flowerList;
        }

        LOGGER.info("list flower with stem {} and {} : {}", from, to, flowerList);
        return flowerList;
    }

    public FlowerPackage getFlowerPackage() {
        return flowerPackage;
    }

    public void setFlowerPackage(FlowerPackage flowerPackage) {
        this.flowerPackage = flowerPackage;

        this.compositionPrice = compositionPrice.add(flowerPackage.getPrice());
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public BigDecimal getCompositionPrice() {
        return compositionPrice;
    }

    public void addFlower(Flower flower) {
        this.flowers.add(flower);
        this.compositionPrice = this.compositionPrice.add(flower.getPrice());
    }

    public void addFlowers(List<Flower> flower) {
        for (Flower flower1 : flower) {

            flowers.add(flower1);
            this.compositionPrice = this.compositionPrice.add(flower1.getPrice());
        }
    }

    @Override
    public String toString() {
        return "FlowerComposition{" +
                "flowers=" + flowers +
                ", compositionPrice=" + compositionPrice +
                '}';
    }

}

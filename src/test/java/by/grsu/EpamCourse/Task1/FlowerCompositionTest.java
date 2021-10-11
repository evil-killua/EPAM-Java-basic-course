package by.grsu.EpamCourse.Task1;

import by.grsu.EpamCourse.Task1.Flower.Flower;
import by.grsu.EpamCourse.Task1.Flower.FlowerFactory;
import by.grsu.EpamCourse.Task1.Flower.FlowerTypes;
import by.grsu.EpamCourse.Task1.Flower.FreshnessType;
import by.grsu.EpamCourse.Task1.Flower.entity.ChamomileFlower;
import by.grsu.EpamCourse.Task1.Flower.entity.ChrysanthemumFlower;
import by.grsu.EpamCourse.Task1.Flower.entity.RoseFlower;
import by.grsu.EpamCourse.Task1.Flower.entity.TulipFlower;
import by.grsu.EpamCourse.Task1.Package.FlowerPackage;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class FlowerCompositionTest {

    private static FlowerComposition flowerComposition;

    public static List<Flower> getFlower() {
        FlowerFactory flowerFactory = new FlowerFactory();
        List<Flower> flowers = new ArrayList<>();

        Flower rose = flowerFactory.getFlower(FlowerTypes.Rose);
        rose.setStem(40);
        rose.setPrice(BigDecimal.valueOf(10));
        rose.setFreshness(FreshnessType.Day_1);

        Flower chrysanthemum = flowerFactory.getFlower(FlowerTypes.Chrysanthemum);
        chrysanthemum.setStem(30);
        chrysanthemum.setPrice(BigDecimal.valueOf(12));
        chrysanthemum.setFreshness(FreshnessType.Day_2);

        Flower chamomile = flowerFactory.getFlower(FlowerTypes.Chamomile);
        chamomile.setFreshness(FreshnessType.Day_3);
        chamomile.setPrice(BigDecimal.valueOf(8));
        chamomile.setStem(24);

        Flower tulip = flowerFactory.getFlower(FlowerTypes.Tulip);
        tulip.setFreshness(FreshnessType.Day_4);
        tulip.setPrice(BigDecimal.valueOf(15));
        tulip.setStem(37);

        Collections.addAll(flowers, rose, chrysanthemum, chamomile, tulip);

        return flowers;
    }

    @BeforeEach
    public void read() {
        flowerComposition = new FlowerComposition();
        FlowerPackage flowerPackage = Main.getFlowerPackage();
        List<Flower> flowers = Main.getFlowers();

        flowerComposition.setFlowerPackage(flowerPackage);
        flowerComposition.addFlowers(flowers);

    }

    @Test
    public void sortByFreshnessTest() {
        FlowerComposition flowerCompositionMock = spy(new FlowerComposition());

        List<Flower> flowerList = getFlower();

        when(flowerCompositionMock.sortByFreshness()).thenReturn(flowerList);

        Assertions.assertEquals(flowerComposition.sortByFreshness(), flowerCompositionMock.sortByFreshness());
    }

    @Test
    public void sortSortedListByFreshnessTest(){
        FlowerComposition fc = new FlowerComposition(getFlower(),Main.getFlowerPackage());
        FlowerComposition flowerCompositionMock = spy(new FlowerComposition());

        List<Flower> flowerList = getFlower();

        when(flowerCompositionMock.sortByFreshness()).thenReturn(flowerList);

        Assertions.assertEquals(fc.sortByFreshness(),flowerCompositionMock.sortByFreshness());

    }

    @ParameterizedTest
    @MethodSource("sumParameters")
    public void getFlowerByStemLengthTest(Integer a, Integer b, List<Flower> flowers) {

        Integer from = a;
        Integer to = b;
        List<Flower> rez = flowers;

        List<Flower> compRez = flowerComposition.getFlowerByStemLength(from, to);

        Assertions.assertEquals(compRez, rez);

    }

    public static Stream sumParameters() {
        List<Flower> f1 = new ArrayList<>();
        f1.add(new ChamomileFlower(BigDecimal.valueOf(8), 24, FreshnessType.Day_3));
        f1.add(new ChrysanthemumFlower(BigDecimal.valueOf(12), 30, FreshnessType.Day_2));

        List<Flower> f2 = new ArrayList<>();
        f2.add(new RoseFlower(BigDecimal.valueOf(10), 40, FreshnessType.Day_1));
        f2.add(new ChrysanthemumFlower(BigDecimal.valueOf(12), 30, FreshnessType.Day_2));
        f2.add(new TulipFlower(BigDecimal.valueOf(15), 37, FreshnessType.Day_4));

        List<Flower> f3 = new ArrayList<>();
        f3.add(new RoseFlower(BigDecimal.valueOf(10), 40, FreshnessType.Day_1));
        return Stream.of(
                Arguments.of(20, 30, f1),
                Arguments.of(30, 40, f2),
                Arguments.of(40, 50, f3),
                Arguments.of(10, 15, new ArrayList<Flower>())
        );
    }

}
package by.grsu.EpamCourse.Task1.Flower;

import by.grsu.EpamCourse.Task1.Flower.entity.ChamomileFlower;
import by.grsu.EpamCourse.Task1.Flower.entity.ChrysanthemumFlower;
import by.grsu.EpamCourse.Task1.Flower.entity.RoseFlower;
import by.grsu.EpamCourse.Task1.Flower.entity.TulipFlower;

import java.util.HashMap;
import java.util.Map;

public class FlowerFactory {

    public Flower getFlower(FlowerTypes types){
        Map<FlowerTypes,Flower> flowerMap = new HashMap<>();
        flowerMap.put(FlowerTypes.Rose,new RoseFlower());
        flowerMap.put(FlowerTypes.Chamomile,new ChamomileFlower());
        flowerMap.put(FlowerTypes.Chrysanthemum,new ChrysanthemumFlower());
        flowerMap.put(FlowerTypes.Tulip,new TulipFlower());

        return flowerMap.get(types);
    }

}

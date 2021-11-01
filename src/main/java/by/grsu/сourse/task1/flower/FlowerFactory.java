package by.grsu.сourse.task1.flower;

import by.grsu.сourse.task1.flower.entity.ChamomileFlower;
import by.grsu.сourse.task1.flower.entity.ChrysanthemumFlower;
import by.grsu.сourse.task1.flower.entity.RoseFlower;
import by.grsu.сourse.task1.flower.entity.TulipFlower;

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

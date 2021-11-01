package by.grsu.сourse.task1.pack;


import by.grsu.сourse.task1.pack.entity.ArtificialLinenFlowerPackage;
import by.grsu.сourse.task1.pack.entity.FilmFlowerPackage;
import by.grsu.сourse.task1.pack.entity.PaperFlowerPackage;
import by.grsu.сourse.task1.pack.entity.RopeFlowerPackage;

import java.util.HashMap;
import java.util.Map;

public class FlowerPackageFactory {

    public FlowerPackage getFlowerPackage(PackageType type){
        Map<PackageType,FlowerPackage> flowerPackageMap = new HashMap<>();
        flowerPackageMap.put(PackageType.ArtificialLinen,new ArtificialLinenFlowerPackage());
        flowerPackageMap.put(PackageType.Film,new FilmFlowerPackage());
        flowerPackageMap.put(PackageType.Paper,new PaperFlowerPackage());
        flowerPackageMap.put(PackageType.Rope,new RopeFlowerPackage());

        return flowerPackageMap.get(type);
    }

}

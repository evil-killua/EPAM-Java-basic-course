package by.grsu.EpamCourse.Task1.Package;


import by.grsu.EpamCourse.Task1.Package.entity.ArtificialLinenFlowerPackage;
import by.grsu.EpamCourse.Task1.Package.entity.FilmFlowerPackage;
import by.grsu.EpamCourse.Task1.Package.entity.PaperFlowerPackage;
import by.grsu.EpamCourse.Task1.Package.entity.RopeFlowerPackage;

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

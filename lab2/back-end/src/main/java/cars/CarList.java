package cars;

import entity.CarEntity;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<CarEntity> carList = new ArrayList<>();

    public CarList() {
        this.carList.add(new CarEntity(
                0,
                "Himars",
                "https://s0.rbk.ru/v6_top_pics/media/img/5/12/756541060352125.jpg",
                1.6));

        this.carList.add(new CarEntity(
                1,
                "MLRS 270",
                "https://apostrophe.ua/uploads/image/cb53eb37570f5425d16d2f214f13dc41.jpg",
                2.2));

        this.carList.add(new CarEntity(
                2,
                "Vilkha",
                "https://telegraf.com.ua/static/storage/originals/d/d2/576df7faf8c6d19f9c4ed26ab02ced2d.jpg",
                1.1));

        this.carList.add(new CarEntity(
                3,
                "LAR 160",
                "https://wikiwarriors.org/mediawiki/images/7/75/LAR-160.jpg",
                2));
    }
    public List<CarEntity> getCarList() {
        return carList;
    }

    public void setCarList(List<CarEntity> carList) {
        this.carList = carList;
    }
}

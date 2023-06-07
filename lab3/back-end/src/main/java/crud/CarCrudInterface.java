package crud;

import entity.CarEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CarCrudInterface {
    public CarEntity readEntity();
    public void updateEntity(CarEntity entity);
    CarEntity carParse(HttpServletRequest request);

    int getIndexByCarId(int id, List<CarEntity> lu);

    int getNextId(List<CarEntity> lu);
}

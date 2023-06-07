package crud;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import entity.CarEntity;
import fileIO.FileIO;
import fileIO.FileIOInterface;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CarCrud implements CarCrudInterface{
    FileIOInterface fio;

    public CarCrud() {
        this.fio = new FileIO();
    }

    @Override
    public CarEntity readEntity() {

        return (CarEntity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(CarEntity entity) {
        fio.saveToFile(entity);
    }

    public JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public CarEntity carParse(HttpServletRequest request) {
        CarEntity car = new CarEntity();
        JsonElement jsonElement = bodyParse(request);
        car.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        car.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        car.setPhoto(jsonElement.getAsJsonObject().get("photo").getAsString());
        car.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return car;
    }

    public int getIndexByCarId(int id, List<CarEntity> list) {
        int listId = id;

        Iterator<CarEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            CarEntity temp =iterator.next();
            if(temp.getId()==listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

    public int getNextId(List<CarEntity> list) {
        int maxId = 0;

        Iterator<CarEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}

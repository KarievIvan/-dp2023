package servlet;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import entity.ShampooEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CRUDConfig {
    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static ShampooEntity shampooParse(HttpServletRequest request) {
        ShampooEntity shampoo = new ShampooEntity();
        JsonElement jsonElement = bodyParse(request);
        shampoo.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        shampoo.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        shampoo.setPhoto(jsonElement.getAsJsonObject().get("photo").getAsString());
        shampoo.setRate(jsonElement.getAsJsonObject().get("rate").getAsInt());
        shampoo.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return shampoo;
    }

    public static int getNextId(List<ShampooEntity> list) {
        int maxId = 0;

        Iterator<ShampooEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}

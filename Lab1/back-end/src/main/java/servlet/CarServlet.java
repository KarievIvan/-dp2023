package servlet;

import com.google.gson.Gson;
import entity.CarEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.ArrayList;

@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CarEntity entity1 = new CarEntity(
                1,
                "Himars",
                "https://s0.rbk.ru/v6_top_pics/media/img/5/12/756541060352125.jpg",
                1.6);

        CarEntity entity2 = new CarEntity(
                2,
                "MLRS 270",
                "https://apostrophe.ua/uploads/image/cb53eb37570f5425d16d2f214f13dc41.jpg",
                2.2);

        CarEntity entity3 = new CarEntity(
                3,
                "Vilkha",
                "https://telegraf.com.ua/static/storage/originals/d/d2/576df7faf8c6d19f9c4ed26ab02ced2d.jpg",
                1.1);

        CarEntity entity4 = new CarEntity(
                4,
                "LAR 160",
                "https://wikiwarriors.org/mediawiki/images/7/75/LAR-160.jpg",
                2);

        ArrayList<CarEntity> cars = new ArrayList<CarEntity>();
        cars.add(entity1);
        cars.add(entity2);
        cars.add(entity3);
        cars.add(entity4);

        String CarJson = new Gson().toJson(cars);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(CarJson);
        out.flush();
    }
}

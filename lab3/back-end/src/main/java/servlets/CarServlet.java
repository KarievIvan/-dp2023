package servlets;


import cars.CarList;
import com.google.gson.Gson;
import crud.CarCrudInterface;
import entity.CarEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CarServlet/*")
public class CarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<CarEntity> cars = new CarList().getCarList();

    CarServletInterface servletConfig;
    CarCrudInterface lab3Crud;

    public CarServlet() {
        super();
        this.servletConfig = new CarServletConfig();
        this.lab3Crud = servletConfig.getCrud();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        String CarJson = new Gson().toJson(cars);
        PrintWriter out = response.getWriter();
        out.print(CarJson);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarEntity car = lab3Crud.carParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = lab3Crud.getIndexByCarId(id, cars);
        cars.set(index,car);
        doGet(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarEntity car = lab3Crud.carParse(request);
        car.setId(lab3Crud.getNextId(cars));
        cars.add(car);
        doGet(request, response);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = lab3Crud.getIndexByCarId(id, cars);
        cars.remove(index);
        doGet(request, response);
    }
}

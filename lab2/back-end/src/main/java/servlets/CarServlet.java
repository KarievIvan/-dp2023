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
    CarCrudInterface lab2Crud;

    public CarServlet() {
        super();
        this.servletConfig = new CarServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        String TentJson = new Gson().toJson(cars);
        PrintWriter out = response.getWriter();
        out.print(TentJson);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarEntity car = lab2Crud.carParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = lab2Crud.getIndexByCarId(id, cars);
        cars.set(index,car);
        doGet(request, response);

    }
}

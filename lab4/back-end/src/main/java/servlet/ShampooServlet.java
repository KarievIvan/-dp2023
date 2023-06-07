package servlet;


import entity.ShampooEntity;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.SqlCRUD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShampooServlet/*")
public class ShampooServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    CRUDInterface<ShampooEntity> crud = new SqlCRUD();

    List<ShampooEntity> list = new ArrayList<>();

    public void init(ServletConfig config) throws ServletException {
        crud = new SqlCRUD();

    }
    public void destroy() {
        try {
            ((SqlCRUD) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.getWriter().println(crud.read());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ShampooEntity shampoo = CRUDConfig.shampooParse(request);
        crud.create(shampoo);
        doGet(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ShampooEntity shampoo = CRUDConfig.shampooParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.update(id, shampoo);
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
        doGet(request, response);
    }
}

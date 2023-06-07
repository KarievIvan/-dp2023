package servlets;

import crud.CarCrud;
import crud.CarCrudInterface;

public class CarServletConfig implements CarServletInterface{
    CarCrudInterface l2ci;

    public CarServletConfig() {
        this.l2ci = new CarCrud();
    }

    @Override
    public CarCrudInterface getCrud() {
        return l2ci;
    }
}

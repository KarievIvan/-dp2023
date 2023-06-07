package servlet;

import java.util.List;

public interface CRUDInterface<D> {
    public void create(D d);
    public List<D> read();
    public void update(int id, D d);
    public void delete(int id);
}

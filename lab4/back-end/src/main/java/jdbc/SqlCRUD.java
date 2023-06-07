package jdbc;

import entity.ShampooEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import servlet.CRUDConfig;
import servlet.CRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements CRUDInterface<ShampooEntity> {

    Connection connection;
    List<ShampooEntity> list = new ArrayList<>();

    public SqlCRUD() {
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(ShampooEntity shampooEntity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(ShampooEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            int id = CRUDConfig.getNextId(list);

            session.save(new ShampooEntity(
                    id,
                    shampooEntity.getName(),
                    shampooEntity.getPhoto(),
                    shampooEntity.getRate(),
                    shampooEntity.getPrice())
            );
            session.getTransaction().commit();
        }
    }

    @Override
    public List<ShampooEntity> read() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(ShampooEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            list = (List<ShampooEntity>) session.createQuery("from ShampooEntity").list();

            session.getTransaction().commit();
        }

        return list;
    }

    @Override
    public void update(int id, ShampooEntity shampooEntity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(ShampooEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            ShampooEntity updateDevice = new ShampooEntity(
                    id,
                    shampooEntity.getName(),
                    shampooEntity.getPhoto(),
                    shampooEntity.getRate(),
                    shampooEntity.getPrice()
            );

            session.update(updateDevice);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection
                .prepareStatement("DELETE FROM shampooes WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

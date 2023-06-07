package jdbc;

import entity.ShampooEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
            .addAnnotatedClass(ShampooEntity.class)
            .buildMetadata()
            .buildSessionFactory()) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(new ShampooEntity(
                1,
                "KEUNE",
                "https://keune.in.ua/wp-content/uploads/2018/07/21808-Keune-1922-Purifying-Shampoo-250ml-API2-online.webp",
                5,
                656
        ));
        session.save(new ShampooEntity(
                2,
                "KEEN",
                "https://eshoping.ua/image/cache/catalog/keen/care/65803750-700x700.png",
                4,
                717
        ));
        session.save(new ShampooEntity(
                3,
                "Sunsilk",
                "https://www.sunsilk.in/content/dam/unilever/sunsilk/india/pack_shot/8901030876790.fop_without_new_flash_01-64280266-png.png",
                5,
                519
        ));

        session.getTransaction().commit();

    }
        System.out.println("You added all data in tents table! :D");
}

}

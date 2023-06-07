package entity;

public class CarEntity {
    private int id;
    private String name;
    private String photo;
    private double price;

    public CarEntity(int id, String name, String photo, double price) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                '}';
    }
}

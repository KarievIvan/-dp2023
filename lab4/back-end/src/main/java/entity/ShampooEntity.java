package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shampooes")
public class ShampooEntity {
    @Id
    private int id;
    private String name;
    private String photo;
    private int rate;
    private int price;

    public ShampooEntity() {
    }

    public ShampooEntity(int id, String name, String photo, int rate, int price) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.rate = rate;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{\"id\": "+id+",\"name\": \""+name+"\",\"photo\":\""+photo+"\", \"price\":"+ price+", \"rate\":"+rate+"}";
    }
}

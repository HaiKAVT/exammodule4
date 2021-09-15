package codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameQG;

    public QuocGia() {
    }

    public QuocGia(int id, String nameQG) {
        this.id = id;
        this.nameQG = nameQG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameQG() {
        return nameQG;
    }

    public void setNameQG(String nameQG) {
        this.nameQG = nameQG;
    }
}

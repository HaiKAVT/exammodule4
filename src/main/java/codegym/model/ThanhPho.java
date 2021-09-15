package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Ten phai co it nhat 1 ky tu")
    private String name;

    @Min(value = 0, message = "DT can not be less than 0")
    private int dienTich;

    @Min(value = 0, message = "Population can not be less than 0")
    private int danSo;

    @Min(value = 0, message = "DS can not be less than 0")
    private int gpa;

    @NotEmpty(message = "gioi thieu phai co it nhat 1 ky tu")
    private String gioiThieu;


    @ManyToOne
    private QuocGia quocGia;

    public ThanhPho() {
    }

    public ThanhPho(int id, String name, int dienTich, int danSo, int gpa, String gioiThieu, QuocGia quocGia) {
        this.id = id;

        this.name = name;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gpa = gpa;
        this.gioiThieu = gioiThieu;
        this.quocGia = quocGia;
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

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getDanSo() {
        return danSo;
    }

    public void setDanSo(int danSo) {
        this.danSo = danSo;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}

package vn.edu.poly.testduan2.model;

public class Bread {

    private String type;
    private byte[] imgBread;
    private String title;
    private int price1;
    private int price2;
    private String topping;

    public Bread(){

    }

    public Bread(String type, byte[] imgBread, String title, int price1, int price2, String topping) {
        this.type = type;
        this.imgBread = imgBread;
        this.title = title;
        this.price1 = price1;
        this.topping = topping;
    }

    public byte[] getImgBread() {
        return imgBread;
    }

    public void setImgBread(byte[] imgBread) {
        this.imgBread = imgBread;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package devmob.processoseletivo.temperodochefe.core.entities;

public class ItemMenu {

    private String name;
    private int price;
    private String img;
    private String notes;
    private String type;

    public ItemMenu() {}

    public ItemMenu(String name, int price, String img, String notes, String type) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.notes = notes;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private String category;

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Геттеры (чтобы можно было читать поля)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Товар[артикул=" + id +
                ", название=" + name +
                ", цена=" + price +
                ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                 // один и тот же объект
        if (!(obj instanceof Product)) return false;   // не Product — точно не равны

        Product other = (Product) obj;

        // id — примитив, сравниваем напрямую
        if (id != other.id) return false;

        // category — строка, сравниваем через Objects.equals (безопасно для null)
        if (!Objects.equals(category, other.category)) return false;

        // name и price не участвуют в равенстве по условию задачи
        return true;
    }

    @Override
    public int hashCode() {
        // hashCode должен учитывать те же поля, что и equals
        return Objects.hash(id, category);
    }
}
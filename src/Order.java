import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        // Если передали null вместо массива, сделаем пустой массив — так безопаснее
        this.basket = (basket == null) ? new Product[0] : basket;
    }

    public String getCustomer() { return customer; }
    public Product[] getBasket() { return basket; }

    @Override
    public String toString() {
        // Arrays.toString() красиво выведет массив, используя toString() у каждого Product
        return "Заказ[покупатель=" + customer + ", корзина=" + Arrays.toString(basket) + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;

        Order other = (Order) obj;

        // Сравниваем покупателя с защитой от null
        if (!Objects.equals(this.customer, other.customer)) return false;

        // Сравниваем массивы по длине
        if (this.basket.length != other.basket.length) return false;

        // Поэлементно сравниваем товары через их equals()
        for (int i = 0; i < this.basket.length; i++) {
            Product p1 = this.basket[i];
            Product p2 = other.basket[i];

            // Если один null, а другой нет — не равны
            if (!Objects.equals(p1, p2)) return false;

            // Если оба не null — используем equals() у Product
            if (p1 != null && !p1.equals(p2)) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customer);
        // Для массива нужно посчитать хэш каждого элемента отдельно
        for (Product p : basket) {
            result = 31 * result + (p == null ? 0 : p.hashCode());
        }
        return result;
    }
}
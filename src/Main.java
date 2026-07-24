public class Main {
    public static void main(String[] args) {
        // Создаём товары
        Product p1 = new Product(101, "Смартфон X", 25000, "Электроника");
        Product p2 = new Product(102, "Наушники Pro", 5000, "Аудио");
        Product p3 = new Product(101, "Смартфон X (скидка)", 23000, "Электроника"); // тот же id и категория
        Product p4 = new Product(103, "Чехол", 1500, "Аксессуары");


        System.out.println("=== Товары ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("\n=== Сравнение товаров ===");
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // true (id и category совпадают)
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // false

        // Создаём заказы
        Product[] basketA = {p1, p2};
        Product[] basketB = {p1, p2};            // точно такой же состав и порядок
        Product[] basketC = {p3, p2};           // p3 считается равным p1 по equals()
        Product[] basketD = {p2, p1};           // другой порядок
        Product[] basketE = {p1};               // меньше товаров

        Order o1 = new Order("Анна", basketA);
        Order o2 = new Order("Анна", basketB);
        Order o3 = new Order("Анна", basketC);
        Order o4 = new Order("Анна", basketD);
        Order o5 = new Order("Борис", basketA); // другой покупатель

        System.out.println("\n=== Заказы ===");
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println(o5);

        System.out.println("\n=== Сравнение заказов ===");
        System.out.println("o1.equals(o2): " + o1.equals(o2)); // true — всё совпадает
        System.out.println("o1.equals(o3): " + o1.equals(o3)); // true — p1 и p3 равны по equals()
        System.out.println("o1.equals(o4): " + o1.equals(o4)); // false — порядок другой
        System.out.println("o1.equals(o5): " + o1.equals(o5)); // false — другой покупатель
    }
}
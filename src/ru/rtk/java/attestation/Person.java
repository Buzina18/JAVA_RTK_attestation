package ru.rtk.java.attestation;

public class Person {
    private String name;
    private double money;
    private Product[] bag;
    private int productCount;
    private double budget;

    public Person(String name, double money) {
        if (name == null || name.trim().isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть пустой строкой и должно быть не короче 3 символов.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными.");
        }
        this.name = name;
        this.money = money;
        this.bag = new Product[10];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (product.getPrice() <= money) {
            if (productCount < bag.length) {
                bag[productCount] = product;
                productCount++;
                money -= product.getPrice();
                System.out.println("Продукт '" + product.getName() + "' добавлен в пакет.");
            } else {
                System.out.println("Пакет заполнен, продукт '" + product.getName() + "' не добавлен.");
            }
        } else {
            System.out.println("Недостаточно денег для покупки продукта '" + product.getName() + "'.");
        }
    }

    public void printPurchases() {
        System.out.println("Покупатель: " + name);
        System.out.println("Остаток денег: " + money);
        System.out.println("Пакет продуктов:");
        for (int i = 0; i < productCount; i++) {
            System.out.println(bag[i]);
        }
    }

    public static void main(String[] args) {
        try {
            Person person1 = new Person("Павел Андреевич", 10000.0);
            Person person2 = new Person("Анна Петровна", 2000.0);
            Person person3 = new Person("Борис", 10.0);
            Product bread = new Product("Хлеб", 40.0);
            Product milk = new Product("Молоко", 60.0);
            Product tort = new Product("Торт", 1000.0);
            Product maslo = new Product("Масло", 150.0);
            Product kofe = new Product("Кофе", 879.0);
            person1.addProduct(bread);
            person1.addProduct(maslo);
            person2.addProduct(milk);
            person2.addProduct(milk);
            person2.addProduct(milk);
            person2.addProduct(kofe);
            person3.addProduct(tort);
            person1.printPurchases();
            person2.printPurchases();
            person3.printPurchases();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
package ru.rtk.java.attestation;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        setName(name); // Устанавливаем название с проверкой
        setPrice(price); // Устанавливаем стоимость с проверкой
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Продукт: " + name + ", Стоимость: " + price;
    }

    public static void main(String[] args) {
        try {
            Product product1 = new Product("Яблоко", 50.0);
            System.out.println(product1);

            Product product2 = new Product("", -10);
            System.out.println(product2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


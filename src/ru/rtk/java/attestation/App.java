package ru.rtk.java.attestation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имена покупателей через запятую:");
        String[] buyers = scanner.nextLine().split(",");

        System.out.println("Введите названия продуктов через запятую:");
        String[] products = scanner.nextLine().split(",");

        List<List<String>> bags = new ArrayList<>();
        for (String buyer : buyers) {
            bags.add(new ArrayList<>());
        }

        boolean shopping = true;
        while (shopping) {
            for (int i = 0; i < buyers.length; i++) {
                System.out.println(buyers[i].trim() + ", выберите продукт или введите 'END' для завершения:");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("END")) {
                    shopping = false;
                    break;
                }

                boolean productExists = false;
                for (String product : products) {
                    if (product.trim().equalsIgnoreCase(input)) {
                        bags.get(i).add(product.trim());
                        productExists = true;
                        break;
                    }
                }

                if (!productExists) {
                    System.out.println("Продукт не найден. Попробуйте снова.");
                }
            }
        }

        for (int i = 0; i < buyers.length; i++) {
            System.out.println(buyers[i].trim() + " выбрал(а) следующие продукты: " + bags.get(i));
        }

        scanner.close();
    }
  }

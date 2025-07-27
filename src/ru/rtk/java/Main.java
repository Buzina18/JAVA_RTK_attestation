package ru.rtk.java;

import ru.rtk.java.attestation.Person;
import ru.rtk.java.attestation.Product;
import ru.rtk.java.attestation.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Павел Андреевич", 10000.0);
        Person person2 = new Person("Анна Петровна", 2000.0);
        Person person3 = new Person("Борис", 10.0);
        Product bread = new Product("Хлеб", 40.0);
        Product milk = new Product("Молоко", 60.0);
        Product tort = new Product("Торт", 1000.0);
        Product maslo = new Product("Масло", 150.0);
        Product kofe = new Product("Кофе", 879.0);
    }

    public void doSomething () {
        System.out.println("do something");
    }

    private static String returnSomeString () {
        return "Some string!";
    }
}


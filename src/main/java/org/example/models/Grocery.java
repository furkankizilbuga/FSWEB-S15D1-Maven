package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int userInput;
        System.out.println("Yapmak istediğiniz işlemi seçiniz: 0 - 1 - 2");

       do {
           userInput = scanner.nextInt();
           scanner.nextLine();
           switch(userInput) {
               case 1:
                   System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                   String itemsAdd = scanner.nextLine();
                   addItems(itemsAdd);
                   printSorted();
                   break;
               case 2:
                   System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                   String itemsRemove = scanner.nextLine();
                   removeItems(itemsRemove);
                   printSorted();
                   break;
           }
       } while(userInput != 0);
       scanner.close();
    }

    public static void addItems(String itemsAdd) {
        String[] items = itemsAdd.split(",");
        for (String item : items) {
            item = item.trim();
            if(!checkItemIsInList(item)){
                groceryList.add(item);
            }
        }
            Collections.sort(groceryList);
    }

    public static void removeItems(String itemsRemove) {
        String[] items = itemsRemove.split(",");
        for (String item : items) {
            item = item.trim();
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}

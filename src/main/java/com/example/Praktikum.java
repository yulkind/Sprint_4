package com.example;

public class Praktikum {

    public static void main(String[] args) {
        String name = "Тимоти Шаламе";
        Account account = new Account(name);
        Account accountNull = new Account(null);

        account.checkNameToEmboss();
        System.out.println(accountNull.checkNameToEmboss());
    }
}

package net.mike.notepad;

import net.mike.notepad.controller.Controller;
import net.mike.notepad.model.Account;
import net.mike.notepad.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        System.out.println("Hallo World!");
        Account a = new Account("aaa", "sss");
        Account b = new Account("aaa", "sss");
        Account c = new Account("aaa", "sss");
        Controller<Account> controller = new Controller<>();
        controller.add(a);
        controller.add(c);
        controller.add(c);
        System.out.println(Model.getInstance().getList().size());

    }
}

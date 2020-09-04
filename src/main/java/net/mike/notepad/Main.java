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
        Account b = new Account("aqefa", "sss");
        Account c = new Account("aaa", "swrgewrgss");
        /*System.out.println(Model.getInstance().getList().add(a));
        System.out.println(Model.getInstance().getList().add(b));
        System.out.println(Model.getInstance().getList().add(c));*/
        Controller<Account> controller = new Controller<>();
        System.out.println();
        controller.add(a);
        controller.add(b);
        controller.add(c);
        System.out.println(a.getId() + " " + b.getId() + " " + c.getId());
        System.out.println(Model.getInstance().getList().size());
    }
}

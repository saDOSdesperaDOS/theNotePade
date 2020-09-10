package net.mike.notepad.controller;

import net.mike.notepad.model.Account;
import net.mike.notepad.model.ModelsAccounts;

public  class Controller<T extends Account> {
    private static int id;
       public void add(T t) {
               ModelsAccounts.getInstance().getList().add(t);
       }

       public boolean remove(T t) {
          return false;
       }

       public boolean create(T t) {
          return false;
       }

      public boolean update(T t) {
          return false;
       }
}

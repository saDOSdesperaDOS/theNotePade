package net.mike.notepad.controller;

import net.mike.notepad.model.Account;
import net.mike.notepad.model.ModelsAccounts;

public  class Controller {
    private static Long id;
       public void add(Account a) {
               ModelsAccounts.getInstance().put(id, a);
       }

       public boolean remove(Account a) {
          return false;
       }

       public boolean create(Account a) {
          return false;
       }

      public boolean update(Account a) {
          return false;
       }
}

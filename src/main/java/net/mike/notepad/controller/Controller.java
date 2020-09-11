package net.mike.notepad.controller;

import net.mike.notepad.model.Account;
import net.mike.notepad.model.ModelsAccounts;

public  class Controller {
    private static Long id;
       public void registration(Account a) {
               ModelsAccounts.getInstance().put(id, a);
       }

       public boolean logout(Account a) {
          return false;
       }

       public boolean auth(Account a) {
          return false;
       }

    public boolean avtorizaton(Account a) {
        return false;
    }

      public boolean login(Account a) {
          return false;
       }
}

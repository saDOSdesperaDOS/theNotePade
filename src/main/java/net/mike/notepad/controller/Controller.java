package net.mike.notepad.controller;

import net.mike.notepad.dbase.entyties.UserDataSet;
import net.mike.notepad.model.RegUserProfileList;

public  class Controller {
    private static Long id;
       public void registration(UserDataSet a) {
               RegUserProfileList.getInstance().put(id, a);
       }

       public boolean logout(UserDataSet a) {
          return false;
       }

       public boolean auth(UserDataSet a) {
          return false;
       }

       public boolean avtorizaton(UserDataSet a) {
        return false;
    }

       public boolean login(UserDataSet a) {
          return false;
       }
}

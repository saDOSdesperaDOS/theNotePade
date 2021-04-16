package net.mike.notepad.controller;

import net.mike.notepad.model.RegUserProfileList;
import net.mike.notepad.dbase.entyties.UserProfileDataSet;

public  class Controller {
    private static Long id;
       public void registration(UserProfileDataSet a) {
               RegUserProfileList.getInstance().put(id, a);
       }

       public boolean logout(UserProfileDataSet a) {
          return false;
       }

       public boolean auth(UserProfileDataSet a) {
          return false;
       }

       public boolean avtorizaton(UserProfileDataSet a) {
        return false;
    }

       public boolean login(UserProfileDataSet a) {
          return false;
       }
}

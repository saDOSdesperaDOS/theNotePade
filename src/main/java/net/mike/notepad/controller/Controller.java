package net.mike.notepad.controller;

import net.mike.notepad.model.RegUserProfileList;
import net.mike.notepad.entyties.UserProfile;

public  class Controller {
    private static Long id;
       public void registration(UserProfile a) {
               RegUserProfileList.getInstance().put(id, a);
       }

       public boolean logout(UserProfile a) {
          return false;
       }

       public boolean auth(UserProfile a) {
          return false;
       }

       public boolean avtorizaton(UserProfile a) {
        return false;
    }

       public boolean login(UserProfile a) {
          return false;
       }
}

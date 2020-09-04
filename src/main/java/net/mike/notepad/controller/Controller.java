package net.mike.notepad.controller;

import net.mike.notepad.model.Account;
import net.mike.notepad.model.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public  class Controller<T extends Account> {
    private static int id;
       public void add(T t) {
               Model.getInstance().getList().add(t);
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

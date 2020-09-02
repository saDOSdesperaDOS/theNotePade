package net.mike.notepad.controller;

import net.mike.notepad.model.Account;
import net.mike.notepad.model.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public  class Controller<T extends Account> {

   public void add(T t) {
       List<T> list = Model.getInstance().getList();
       list.add(t);
       Stream.of(list).distinct().toArray();
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

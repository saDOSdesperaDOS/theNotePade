package net.mike.notepad.controller;

import net.mike.notepad.model.Note;

public  class Controller<T> {
   public boolean add(T t) {
      if (t instanceof Note) {

      }
      return false;
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

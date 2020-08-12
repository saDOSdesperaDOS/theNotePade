package net.mike.notepad.service;

public abstract class Service<T> {
   abstract boolean add(T t);
   abstract boolean remove(T t);
   abstract boolean create(T t);
   abstract boolean update(T t);
}

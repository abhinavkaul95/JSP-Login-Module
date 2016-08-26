package com.training.ifaces;

import java.util.List;

public interface InterfaceMyDAO<T> {
	public int add(T t);
	public int update(long id, String username, String password);
	public T find(long id);
	public int delete(long id);
	public List<T> findAll();
	public void close();
}

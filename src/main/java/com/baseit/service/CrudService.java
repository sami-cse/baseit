package com.baseit.service;

import java.util.*;


public interface CrudService<T, K> {

	List<T> getLists();

	T getById(K index);

	void add(T t);

	void edit(T t);

	void delete(K index);
}

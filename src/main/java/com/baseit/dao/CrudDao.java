package com.baseit.dao;

import java.util.*;

public interface CrudDao<T, K> {

	List<T> getLists();

	T getById(K index);

	void add(T t);

	void edit(T t);

	void delete(K index);
}

package com.baseit.serviceimpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baseit.dao.*;
import com.baseit.models.*;
import com.baseit.service.*;

@Service
public class ProductServiceImpl implements CrudService<Product, Integer> {

	@Autowired
	CrudDao<Product, Integer> crudDao;

	@Override
	public List<Product> getLists() {
		return crudDao.getLists();
	}

	@Override
	public Product getById(Integer index) {
		return crudDao.getById(index);
	}

	@Override
	public void add(Product product) {
		crudDao.add(product);
	}

	@Override
	public void edit(Product product) {
		crudDao.edit(product);
	}

	@Override
	public void delete(Integer index) {
		crudDao.delete(index);
	}

}

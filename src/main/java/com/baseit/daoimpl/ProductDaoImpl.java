package com.baseit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baseit.dao.*;
import com.baseit.models.Product;

@Repository
@Transactional
public class ProductDaoImpl implements CrudDao<Product, Integer> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getLists() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
		session.flush();

		return productList;
	}

	@Override
	public Product getById(Integer index) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, index);
		session.flush();

		return product;
	}

	@Override
	public void add(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public void edit(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public void delete(Integer index) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getById(index));
		session.flush();
	}

}

package com.cts.rest.repository;

import java.util.List;

import com.cts.rest.entity.Product;


// DAO classes

public interface ProductRepository {

	void save(Product product);

	Product find(int id);

	List<Product> findAll();

	void update(Product product);

	void delete(int id);

}
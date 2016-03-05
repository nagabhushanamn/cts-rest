package com.cts.rest.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cts.rest.entity.Product;


/*
 *  In  Java , major Data-Access technologies for RDBMS
 *  
 *  -> JDBC
 *  -> Hibernate
 *  -> iBatis
 *  -> Toplink
 *  -> EclipseLink
 *  -> JPA
 * 
 */

//@Component
public class HibernateProductRepository implements ProductRepository {

	private static SessionFactory sessionFactory = null;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.rest.repository.ProductRepository#save(com.cts.rest.entity.
	 * Product)
	 */
	@Override
	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.save(product);
		session.getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.rest.repository.ProductRepository#find(int)
	 */
	@Override
	public Product find(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Product product = (Product) session.get(Product.class, id);
		session.getTransaction().commit();
		return product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.rest.repository.ProductRepository#findAll()
	 */
	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.getTransaction().commit();
		return products;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cts.rest.repository.ProductRepository#update(com.cts.rest.entity.
	 * Product)
	 */
	@Override
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.merge(product);
		session.getTransaction().commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.rest.repository.ProductRepository#delete(int)
	 */
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.delete(session.load(Product.class, id));
		session.getTransaction().commit();
	}

}

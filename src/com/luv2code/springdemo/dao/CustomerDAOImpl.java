package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	SessionFactory factory;

	@Override
	public List<Customer> getCustomers() {
		
		Session session= factory.getCurrentSession();
		
		List<Customer> listOfCustomers= new ArrayList<>();
		
		Query<Customer> temporaryList= session.createQuery("from Customer c ORDER BY c.lastName", Customer.class);
		
		listOfCustomers= temporaryList.getResultList();
		
		return listOfCustomers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session= factory.getCurrentSession();
		
		System.out.println("Saving Customer " + customer);
		
		session.saveOrUpdate(customer);
		
	}
	@Override
	public Customer getCustomer(int idCustomer) {
		
		Session session=factory.getCurrentSession();
		
		Customer customerToReturn= session.get(Customer.class, idCustomer);
		
		return customerToReturn;
	}

	@Override
	public void deleteCustomer(int idCustomer) {
		
		Session session= factory.getCurrentSession();
		
		session.createQuery("Delete from Customer where id= " + idCustomer).executeUpdate();
		
	}
	
	

}

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
	@Transactional
	public List<Customer> getCustomers() {
		
		Session session= factory.getCurrentSession();
		
		List<Customer> listOfCustomers= new ArrayList<>();
		
		Query<Customer> temporaryList= session.createQuery("from Customer", Customer.class);
		
		listOfCustomers= temporaryList.getResultList();
		
		return listOfCustomers;
	}

}
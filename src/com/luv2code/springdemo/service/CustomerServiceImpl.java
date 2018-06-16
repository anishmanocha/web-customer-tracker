package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getCustomers() {
		
		List<Customer> listOfCustomers= customerDAO.getCustomers();
		
		return listOfCustomers;
	}
	
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
	}

	@Transactional
	public Customer getCustomer(int customerId) {
		
		Customer customerToReturn= customerDAO.getCustomer(customerId);
		
		return customerToReturn;
	}

	@Override
	public void deleteCustomer(int idCustomer) {
		
		customerDAO.deleteCustomer(idCustomer);
		
	}

}

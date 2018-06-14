package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.dao.CustomerDAOImpl;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> listOfCustomers= customerService.getCustomers();
		
		model.addAttribute("listOfCustomers", listOfCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model theModel) {
		
		Customer theCustomer= new Customer();
		
		//I think customer is referring to something or some tag on the jsp form
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer customerToSendToFrontEnd= customerService.getCustomer(theId);
		
		theModel.addAttribute("customer", customerToSendToFrontEnd);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}

}

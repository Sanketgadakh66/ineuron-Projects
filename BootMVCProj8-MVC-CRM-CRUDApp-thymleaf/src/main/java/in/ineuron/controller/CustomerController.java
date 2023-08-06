package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/list")
	public String listCustomer(Map<String,Object> model) {
		System.out.println("Implementation class is :: " + service.getClass().getName());
		List<Customer> customers = service.getCustomers();
		customers.forEach(System.out::println);
		model.put("customers", customers);
		return "/customers/list-customers";
	}
	
	@GetMapping("/showForm")
	public String showForm(Map<String,Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return "/customers/customer-list";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer);
		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam Integer customerId,Map<String,Object> model) {
		Customer customer = service.getCustomerById(customerId);
		System.out.println(customer);
		model.put("customer", customer);
		return "/customers/customer-list";
	}
	
	@PostMapping("/showFormDelete")
	public String showFormDelete(@RequestParam Integer customerId,Map<String,Object> model) {
		service.deleteCustomerById(customerId);
		return "redirect:/customer/list";
	}
}

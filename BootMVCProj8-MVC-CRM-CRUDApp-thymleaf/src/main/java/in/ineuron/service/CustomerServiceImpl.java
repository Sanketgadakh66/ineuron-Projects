package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICutsomerDao;
import in.ineuron.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICutsomerDao repo;
	
	public List<Customer> getCustomers() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		 repo.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Optional<Customer> optional = repo.findById(customerId);
		return optional.get();
	}

	@Override
	public void deleteCustomerById(Integer customerId) {
		repo.deleteById(customerId);
	}

}

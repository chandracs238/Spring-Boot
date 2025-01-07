package com.bankservice.service;

import com.bankservice.exception.CustomerNotFoundException;
import com.bankservice.model.Customer;
import com.bankservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer findCustomerByName(String name){
        return customerRepository.findByCustomerName(name).orElse(null);
    }

    public Customer findCustomerByEmail(String email){
        return customerRepository.findByEmail(email).orElse(null);
    }

    public Customer addNewCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomerById(Customer customer, Long id){
        customerRepository.findById(id).map(customer1 -> {
                    customer1.setCustomerName(customer.getCustomerName());
                    customer1.setEmail(customer.getEmail());
                    return customer1;}).orElseThrow(() -> new CustomerNotFoundException(id));
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }
}

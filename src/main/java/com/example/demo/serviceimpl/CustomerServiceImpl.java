package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Account saveCustomer(Account account) {
   
    	account.setCreateBy("SYSTEM");
        return customerRepository.save(account);
	}
    
    @Override
    public void delCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
    
    @Override
    public void delAll() {
        customerRepository.deleteAll();
    }

    @Override
    public Account findOneById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    @Override
    public Account findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Account findByEmailAndPassword(String email, String password) {
    	Account list = customerRepository.findByEmailAndPassword(email, password);
    	System.out.println("2"+list);
    	return list;
    }

    @Override
    public Account queryByEmail(String email) {
        return customerRepository.queryByEmail(email);
    }

}

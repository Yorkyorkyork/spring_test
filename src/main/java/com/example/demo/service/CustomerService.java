package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;



public interface CustomerService {
    
	Account saveCustomer(Account account);
    
    void delCustomerById(Long id);
    
    void delAll();
    
    Account findOneById(Long id);
    
    Account findByEmail(String email);
    
    

    Account findByEmailAndPassword(String email, String password);

    Account queryByEmail(String email);

}
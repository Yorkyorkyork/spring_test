package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.EmailDTO;
import com.example.demo.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.CustomerService;


@RestController
@RequestMapping(value = "/api/cus")
@Transactional(rollbackFor = {Exception.class})
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmailRepository emailRepository;
    
    @PostMapping(value = "/add")
    public String addUser(Account account) {  //測試時不要加@Requestbody
        EmailDTO emailItem = emailRepository.getById(account.getEmail());

        if (emailItem.getStatus() != 1) {
            return "尚未驗證";
        }

        account = customerService.saveCustomer(account);
        return "新增成功，返回用戶id為：" + account.getId();
    }
    
    @GetMapping(value = "/EmailCheck")
    public boolean findByEmail(@RequestParam String email) {
		Account account = customerService.findByEmail(email);
    	return account != null;
    }
    
    
    @GetMapping(value = "/find")
    public Account findUser(@RequestParam("id") Long id) {
        return customerService.findOneById(id);
    }
    
    
    @PostMapping(value = "/del")
    public String delUser(@RequestParam("id") Long id) {
        customerService.delCustomerById(id);
        return "用戶id為：" + id + "，已被删除!";
    }
    
    
    @PostMapping(value = "/findall")
    public Account findUserByCodeAndEmail(@RequestBody String email,String password) {
    	Account list;
    	
        list = customerService.findByEmailAndPassword(email, password);
        if(list == null) {
        	System.out.println("Error");
        	return null;
        }
        System.out.println("1"+list);
    	return list;
    }

}

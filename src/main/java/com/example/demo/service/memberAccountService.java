package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Account;

public interface memberAccountService {
	
	//註冊時要比對email
	public String signUp(Account account);

	public String login(String account);
	
	//public Account showAccountData(String account);

	String findByEmailAndPassword(Account account);
	
	//public Account showAccountData(Account account);
	
	//public Account showAccountData(Long id);
	
	//public Account flushAccountData(Account account);

	

	
}

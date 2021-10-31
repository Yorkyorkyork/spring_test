package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Account;
import com.example.demo.repository.memberServiceRepository;
import com.example.demo.service.memberAccountService;
import com.example.demo.service.helper.Sha256HelperImpl;

@Service
public class memberAccountServiceImpl implements memberAccountService{
	
	@Autowired
	private Sha256HelperImpl s256;
	
	@Autowired
	private memberServiceRepository msr;
	
	
	@Override
	public String signUp(Account account) {
		
		account.setNickName("123");
		account.setCreateBy("SYSTEM");
		
		
		if(msr.findByEmail(account.getEmail())!=null) {
			return "信箱重複";
		}	
		account.setPassword(s256.Encryption(account.getPassword()));
		msr.save(account);
		return "完成註冊";
	}
	@Override
	public String findByEmailAndPassword(Account account) {
		
		String str1 = s256.Encryption(account.getPassword());
		System.out.println("使用者輸入"+str1);
		
		String str2 = msr.findByEmail(account.getEmail()).getPassword();
		System.out.println("資料庫對比用帳號加密"+str2);
		
		if(msr.findByEmail(account.getEmail()).getEmail() == null) {
			return null;
		}else if(!str2.equals(str1))
			{
			return null;
			}
		return "完成登入";
	}
	private byte[] getSHA(String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String login(String email) {
		
		System.out.println(email);
		Account data = msr.queryByEmail(email);
		System.out.println("4"+data);
		if(data == null) {
			System.out.println("跑到這邊");
			return null;
		}
		
		return "有跑這邊";
	}
}
	


	

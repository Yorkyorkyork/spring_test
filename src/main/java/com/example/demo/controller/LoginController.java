package com.example.demo.controller;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.model.ResultViewModel;
import com.example.demo.service.memberAccountService;
import com.example.demo.service.helper.Sha256HelperImpl;

@RestController
@RequestMapping(value = "/api1/custo")
public class LoginController {
	
	@Autowired
	private  memberAccountService mas ;
	
	@Autowired
	private Sha256HelperImpl s256;
	
	ResultViewModel rvm = new ResultViewModel();
	
	
//	Cookies Start	
	/*@GetMapping()
	public String CreateCookie(HttpServletResponse  response,Account account)
	{
		String  hashCookie = s256.Encryption(account.getEmail());
		Cookie cookie = new Cookie("userName",hashCookie);
		cookie.setMaxAge(1800+(60*60*8));
		response.addCookie(cookie);
		return "Ok";
	}*/
	
	@GetMapping("/Gets")
	public String GetCookie(HttpServletRequest request)
	{
		return Arrays.stream(request.getCookies())
				.filter(m->m.getName().equals("userName"))
				.findFirst()
				.map(m->m.getValue())
				.orElse(null);
	}
	
	
	@GetMapping("/Get")
	public String GetCookie(@CookieValue("userName") String userName)
	{
		System.out.println("test"+userName);
		return "success";
	}
	@PostMapping(value = "/signUp")
	public ResponseEntity<ResultViewModel> signUp(@RequestBody Account account) {
		
		System.out.println(account);
		String data = mas.signUp(account);
		
		rvm.setCode(200);
		rvm.setMessage("帳號");
		rvm.setData("/EscapeME_Home.html");
		return new ResponseEntity<ResultViewModel>(rvm,HttpStatus.OK);
		
	}
	
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<ResultViewModel> logIn(@RequestBody Account account, HttpServletResponse  response) {

		String result = mas.findByEmailAndPassword(account);
		System.out.println("2"+result);
		if(result == null) {
			rvm.setCode(200);
			rvm.setMessage("帳密有誤");
			rvm.setData("/EscapeME_Login.html");
			return new ResponseEntity<ResultViewModel>(rvm,HttpStatus.OK);
		}
		String  hashCookie = account.getEmail();
		Cookie cookie = new Cookie("userName",hashCookie);
		cookie.setMaxAge(1800+(60*60*8));
		response.addCookie(cookie);
		
		rvm.setCode(200);
		rvm.setMessage("ok");
		rvm.setData("/EscapeME_Home.html");
		return new ResponseEntity<ResultViewModel>(rvm,HttpStatus.OK);	
	}
	
	@PostMapping(value = "/gin")
	public ResponseEntity<ResultViewModel> test(String str) {
		String str1 ="123";
		String str2 ="123";
		System.out.println(s256.Encryption(str1));
		System.out.println(s256.Encryption(str2));
		return null;
	
	}
	
}

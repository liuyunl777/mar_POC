package com.demo.account;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.beans.Account;
import com.demo.util.ApiResult;
import com.google.protobuf.Service;

import javassist.expr.NewArray;

@Controller
public class AccountController {

	@Autowired
	private AccountService service;
	
	//Signup
	@PostMapping("/account/signup")
	public @ResponseBody ApiResult signUp(@Validated final Account account,BindingResult result) {
		
		//ApiResult result2=null;
		if(result.hasErrors()) {
			final ApiResult result2=new ApiResult(false, null);
			result.getFieldErrors().forEach(e->{
				result2.getMessages().add(e.getDefaultMessage());
			});
			return result2;
		}
		
		if(!service.validAccount(account)) {
			return new ApiResult(false, "try other email!");
		}

		boolean success=service.saveAccount(account);
		if(success) {
			return new ApiResult(true, "success!");
		}		
		return new ApiResult(false, "failed!");		
	}
	
	
	//login
	@PostMapping("/account/login")
	public @ResponseBody ApiResult login(final Account account,BindingResult result, HttpSession session) throws Exception {
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(account.getPassword()==null||account.getPassword().replaceAll(" ","").length()<6) return new ApiResult(false, "wrong password format!");
		if(account.getEmail()==null||!account.getEmail().matches(regex)) return new ApiResult(false, "wrong email format!");
		if(result.hasErrors()){
			final ApiResult result2=new ApiResult(false, null);
			result.getFieldErrors().forEach(equals->{
				result2.getMessages().add(equals.getDefaultMessage());
			});
			return result2; 
		}
		Account wholeAccount=service.checkPassword(account);

		if(wholeAccount==null) {			
			throw new PasswordFailException();
			//return new ApiResult(false, "password incorrect!");
		}
		
		session.setAttribute("user", wholeAccount);
		System.out.println("email:"+wholeAccount.getEmail());
		System.out.println("name:"+wholeAccount.getName());
		System.out.println("id:"+wholeAccount.getId());
		//session.setAttribute(name, value);
		//response.sendRedirect("/Onlinebanking/home");

		return new ApiResult(true, "password correct! welcome "+ wholeAccount.getName());
	}
	
	
	//logout
	@PostMapping("/account/logout")
	public @ResponseBody ApiResult logout(HttpSession session) {
		session.invalidate();
		return  new ApiResult(true, "Your are loged out!");
	}
	
	
	//api
	
	
	@ExceptionHandler(value = PasswordFailException.class)
	public @ResponseBody ApiResult name() {
		return new ApiResult(false, "password incorrect!");
	}
	
	
	
}

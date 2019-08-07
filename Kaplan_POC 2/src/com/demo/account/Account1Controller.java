package com.demo.account;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Account1Controller {

	@Autowired
	private AccountService serice;
	
	
	@PostMapping("/addAccount")
	public ResponseEntity<Map> addAccount(String accountNum,String accountName){       
		
		Map ans
		if(accountNum==null||accountName==null||accountName.trim().equals("")||accountNum.length()<60) {
			return //return error message
		}
		boolean isSuccess=serice.addAccount(accountNum,accountName);
		if(!isSuccess) {
			return //return error message
		}
		return ResponseEntity.ok().body(ans);//return insert successful message
		  		
	}
}

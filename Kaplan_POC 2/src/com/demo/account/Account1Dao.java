package com.demo.account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class Account1Dao {

	@Autowired
	SessionFactory seeFactory;
	
	public boolean addAccount(String accountNum,String accountName) {
		Session session=seeFactory.getCurrentSession();
		session.beginTransaction();
		int count= session.createNativeQuery("insert into account(account_num,account_name) value (?,?)").setParameter(1, accountNum)
		.setParameter(2, accountName).executeUpdate();
		if(count==0) {
			return false;
		}
		return true;
		
	}
}

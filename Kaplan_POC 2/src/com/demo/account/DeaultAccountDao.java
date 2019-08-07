package com.demo.account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.demo.beans.Account;

@Repository
@Qualifier("oldDao")
public class DeaultAccountDao implements AccountDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAccount(Account account) {
	
		Session session=sessionFactory.getCurrentSession();
		session.save(account);
		if(account.getId()==0) return false;
		return true;
	}

	@Override
	public boolean validAccount(Account account) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
				
		Account newaAccount=session.createQuery("from Account where email=?1",Account.class).setParameter(1, account.getEmail()).uniqueResult();
		if(newaAccount==null) return true;
		return false;
	}

	@Override
	public Account checkPassword(Account account) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		Account getAccount=session.createQuery("from Account where email=?1 and password=?2", Account.class)
				.setParameter(1, account.getEmail())
				.setParameter(2, account.getPassword())
				.uniqueResult();
		
		return getAccount;
		
	}

}

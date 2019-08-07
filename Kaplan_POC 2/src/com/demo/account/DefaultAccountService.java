package com.demo.account;

import org.hibernate.engine.spi.ExceptionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.beans.Account;

@Service
public class DefaultAccountService implements AccountService{

	@Autowired
	@Qualifier("oldDao")
	private AccountDao dao;

	@Autowired
	private AccountDao newDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean saveAccount(Account account) {		
		return newDao.saveAccount(account);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean validAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.validAccount(account);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Account checkPassword(Account account) {
		// TODO Auto-generated method stub
		return dao.checkPassword(account);
	}
	

	

}

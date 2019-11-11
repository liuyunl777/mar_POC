package com.demo.account;

import com.demo.beans.Account;

public interface AccountDao {

	public boolean saveAccount(Account account);
	public boolean validAccount(Account account);
	public Account checkPassword(Account account);
}

package com.demo.account;

import com.demo.beans.Account;

public interface AccountService {

	public boolean saveAccount(Account account);
	public boolean validAccount(Account account);
	public Account checkPassword(Account account);
}

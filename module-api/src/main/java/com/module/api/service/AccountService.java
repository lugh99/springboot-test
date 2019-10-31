package com.module.api.service;

import java.util.List;

import com.module.api.entity.Account;

public interface AccountService {
	
	public Account findByNo(String accountNo);
	
	public List<Account> findAll();
	
	public boolean addAccount(Account account);
	
	public boolean UpdateAccount(Account account);
	
	public boolean DelAccount(String accountNo);
}

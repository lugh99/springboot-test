package com.module.api.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.api.dao.AccountDao;
import com.module.api.entity.Account;
import com.module.api.service.AccountService;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account findByNo(String accountNo) {
		return accountDao.findByNo(accountNo);
	}

	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public boolean addAccount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public boolean UpdateAccount(Account account) {
		return accountDao.UpdateAccount(account);
	}

	@Override
	public boolean DelAccount(String accountNo) {
		return accountDao.DelAccount(accountNo);
	}

}

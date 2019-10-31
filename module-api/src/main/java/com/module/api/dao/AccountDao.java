package com.module.api.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.module.api.entity.Account;

@Component
public class AccountDao {
	
	private static Map<String,Account> accountMap;
	
	public AccountDao() {
		accountMap = new HashMap<String,Account>();
		//初始化2个资金账户
		Account acc1 = new Account();
		acc1.setId(1);
		acc1.setAccountNo("A000001");
		acc1.setAccountName("Account_A");
		acc1.setAccountBalance(1000.00);
		acc1.setRemark("");
		accountMap.put("A000001", acc1);
		Account acc2 = new Account();
		acc2.setId(2);
		acc2.setAccountNo("B000001");
		acc2.setAccountName("Account_B");
		acc2.setAccountBalance(2000.00);
		acc1.setRemark("");
		accountMap.put("B000001", acc2);
	}
	
	public Account findByNo(String accountNo){
		return accountMap.get(accountNo);
	}
	
	public List<Account> findAll(){
		return new ArrayList<Account>(accountMap.values());
	}
	
	public boolean addAccount(Account account){
		accountMap.put(account.getAccountNo(), account);
		return true;
	}
	
	public boolean UpdateAccount(Account account){
		Account acc = accountMap.get(account.getAccountNo());
		acc.setAccountBalance(account.getAccountBalance());
		acc.setRemark(account.getRemark());
		accountMap.put(acc.getAccountNo(), acc);
		return true;
	}
	
	public boolean DelAccount(String accountNo){
		accountMap.remove(accountNo);
		return true;
	}
}

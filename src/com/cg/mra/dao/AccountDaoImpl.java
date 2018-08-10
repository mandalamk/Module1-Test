package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl {

	Map<String,Account> accountEntry;

	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
		
		accountEntry = new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid","Vaishali",200));
		accountEntry.put("9823920123", new Account("Prepaid","Megha",453));
		accountEntry.put("9932012345", new Account("Prepaid","Vikas",631));
		accountEntry.put("9010210132", new Account("Prepaid","Anju",521));
		accountEntry.put("9010210133", new Account("Prepaid","Tushar",632));
		
	}

	
	public Account getAccountDetails(String mobileNo) {
		
		return accountEntry.get(mobileNo);
	}
	



	public int rechargeAccount(String mobileNo, double rechargeAmount)
	{
		double new_bal = rechargeAmount+ accountEntry.get(mobileNo).getAccountBalance();
		int bal = (int)new_bal;
		accountEntry.get(mobileNo).setAccountBalance(new_bal);
		return bal;
	}


	public boolean exists(String mobileNo) {
		
		return accountEntry.containsKey(mobileNo);
	}
}

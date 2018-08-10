package com.cg.mra.service;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import com.cg.Exceptions.MyException;
import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountServices {

	AccountDaoImpl adi = new AccountDaoImpl();
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account getAccountDetails(String mobileNo) throws MyException {
		
		check(mobileNo);
		return adi.getAccountDetails(mobileNo);
	}


	private void check(String mobileNo) throws MyException {
		

		if(!Pattern.matches("[0-9]{10}", mobileNo))
			throw new MyException("Mobile number invalid! Should be of 10 digits.");
		
		if(!adi.exists(mobileNo))
		{
			throw new MyException("Given Account ID does not Exist.");
		}
		
			
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) throws MyException  {
		
		check(mobileNo);
		int balance = adi.rechargeAccount(mobileNo, rechargeAmount);
		return balance;
	}

}

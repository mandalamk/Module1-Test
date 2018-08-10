/**
 * 
 */
package com.cg.mra.service;

import com.cg.Exceptions.MyException;
import com.cg.mra.beans.Account;

/**
 * @author makaran
 *
 */
public interface AccountServices {
	
	Account getAccountDetails(String mobileNo) throws MyException;
	int rechargeAccount(String mobileNo, double rechargeAmount) throws MyException;
	

}

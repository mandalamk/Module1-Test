/**
 * 
 */
package com.cg.mra.dao;

import com.cg.mra.beans.Account;

/**
 * @author makaran
 *
 */
interface AccountDao {
	
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);


}

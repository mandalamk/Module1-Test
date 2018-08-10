/**
 * 
 */
package com.cg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.InputMismatchException;

import org.junit.Test;

import com.cg.Exceptions.MyException;
import com.cg.mra.service.AccountServiceImpl;

/**
 * @author makaran
 *
 */

public class TestCases {

	AccountServiceImpl asimpl = new AccountServiceImpl();

	@Test
	public void test() throws MyException {
		assertEquals("500.0",Double.toString(asimpl.rechargeAccount("9010210131", 300)));
	}
	
	@Test(expected = MyException.class)
	public void testException1() throws MyException 
	{
		
				asimpl.rechargeAccount("901010131", -30);
		
		
	}
	


}

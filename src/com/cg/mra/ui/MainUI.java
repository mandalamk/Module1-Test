package com.cg.mra.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.Exceptions.MyException;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public MainUI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InputMismatchException{
		// TODO Auto-generated method stub
		
		System.out.println("*********MENU*********");
		System.out.println(" 1.Account Balance Enquiry \n 2.Recharge Account \n 3.Exit");
		Scanner sc = new Scanner(System.in);
		AccountServiceImpl asi = new AccountServiceImpl();
		int n = sc.nextInt();
		
		switch(n)
		{
			case(1):
			{
				System.out.print("Enter Mobile No.:");
				String mobileNo="";
				mobileNo = sc.next();
				try {
					System.out.println("Your current Balance is "+asi.getAccountDetails(mobileNo).getAccountBalance());
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
				catch(InputMismatchException e) {
					System.out.println("Input numbers only.");
				}
				break;
			}
		
			case(2):
			{
				System.out.print("Enter Mobile No.: ");
				String mobileNo = sc.next();
				double recharge=0;
				try {
					System.out.print("Enter Recharge Amount: ");
					recharge = sc.nextDouble();
					if(recharge<0) {
						extracted();
					}
				} catch (InputMismatchException e1) {
					// TODO Auto-generated catch block
					System.out.println("Input numbers only.");
					break;
				}
				catch(MyException e1)
				{
					System.out.println(e1.getMessage());
					break;
				}
			
				try {
					asi.rechargeAccount(mobileNo, recharge);
					System.out.println("Your account recharged successfully.");	
					System.out.println("Hello "+ asi.getAccountDetails(mobileNo).getCustomerName()+", Available balance is "+asi.getAccountDetails(mobileNo).getAccountBalance());;
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			}
		
			case(3):
			{
				System.out.println("Thank you for Banking!");
				break;
			}
		}
		
		sc.close();

	}

	private static void extracted() throws MyException {
		throw new MyException("No negative values allowed.");
	}

}

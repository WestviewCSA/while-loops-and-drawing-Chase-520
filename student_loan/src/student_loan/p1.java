package student_loan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class p1 {
	
	
	public static double round_numbers(double num) {
		num *=100;
		double result = Math.round(num);
		
		double re = result/100.0;
		
		return re;

	}
	
	public static String get_two_deci(double num) {
		String res = String.format("%.2f",num);
		return res;
		
	}
	
	public static double getParams(String prompt, double min, double max) {
		Scanner scan = new Scanner(System.in);
		
		// User input
		System.out.println(prompt);
		double numIn = scan.nextDouble();
		
		
		while(numIn <min || numIn>max) {
			System.out.println(prompt);
			numIn = scan.nextDouble();
		}
		
		return numIn;
	}
	
	public static void printHeader() {
		System.out.println("Month   Principal   Interest   Balance");
		System.out.println("-----   --------    -------    -------");
	}
	
	
	public static double printMonthlyData(int month,double pay,double rate,double balance) {
		// params:int month, double principal, double interest, double loaned
		double principal = (pay-balance*rate)/(1+rate);
		double interest = pay-principal;
		balance += principal;
		//System.out.println("Month   Principal   Interest   Balance");
		
		// round numbers
	
		principal = round_numbers(principal);
		interest = round_numbers(interest);
		balance = round_numbers(balance);
		// Indentation of the table
		String mon = ""+month;
		if(mon.length()==2) {
			System.out.println(month+"      "+principal+"       "+interest+ "       "+balance);
		}
		else {
			System.out.println(month+"       "+principal+"       "+interest+ "       "+balance);
		}
		
		// the end of the function
		return balance;
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// User input
			//initializing
		double monthly_payment = 0;
		double interest_rate = 0;
		double years = 0;
		
		boolean correct_value = false;
		while(!correct_value) {
			try {
				monthly_payment = getParams("Please enter the monthly payment: ",0.0,1000.0);
				correct_value = true;
			}
			catch(InputMismatchException e1) {
				System.out.println("\n"+"*****invalid input type, please enter a new value again*****"+"\n");
			}
		}
		correct_value = false;

		
		while(!correct_value) {
			try {
				interest_rate = getParams("Please enter the interest rate(percentage 2.6% = 2.6): ",0,100)/100; //10% is 0.1 in this case
				correct_value = true;
			}
			catch(InputMismatchException e1) {
				System.out.println("\n"+"*****invalid input type, please enter a new value again*****"+"\n");			}
		}
		correct_value = false;

		
		while(!correct_value) {
			try {
				years = getParams("Please enter the duration of the loan, in years: ",0,10);				
				correct_value = true;
			}
			catch(InputMismatchException e1) {
				System.out.println("\n"+"*****invalid input type, please enter a new value again*****"+"\n");			}
		}
		correct_value = false;

		
		// Header
		printHeader();
		
		// Calculation
		double balance = 0;
		double monthly_interest = interest_rate/(years*12);
		
		
		// Initialize the calculation
		double princ = round_numbers(monthly_payment/(1+monthly_interest));
		double inter = round_numbers(monthly_payment - princ);
		balance += princ;
		
		System.out.println((int)(years*12)+"      "+princ+"       "+inter+ "       "+balance);
		
		
		// loop through months
		for(int i=(int)(years*12)-1;i>0;i--) {
			balance = printMonthlyData(i,monthly_payment,monthly_interest,balance);
		}
		
		
	}

}

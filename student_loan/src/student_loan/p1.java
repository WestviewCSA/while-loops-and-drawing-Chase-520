package student_loan;

import java.util.Scanner;

public class p1 {
	
	
	public static void print_round_numbers(int month, double princ, double inter, double balance) {
		String Princ = ""+princ;
		String Inter = ""+inter;
		String Balance = ""+balance;

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
		System.out.println(month+"   "+principal+"   "+interest+ "   "+balance);
		return balance;
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// User input
		//double salary = getParams("Please enter  you desired hourly salary",12,22);
		double monthly_payment = getParams("Please enter the monthly payment: ",0.0,1000.0);
		double interest_rate = getParams("Please enter the interest rate(percentage 2.6% = 2.6): ",0,100)/100; //10% is 0.1 in this case
		double years = getParams("Please enter the duration of the loan, in years: ",0,10);
		
		// Header
		printHeader();
		
		// Calculation
		double balance = 0;
		double monthly_interest = interest_rate/(years*12);
		
		// Initialization
		double princ = monthly_payment/(1+monthly_interest);
		double inter = monthly_payment - princ;
		balance += princ;
		System.out.println((int)(years*12)+"   "+princ+"   "+inter+ "   "+balance);
		
		
		// loop
		for(int i=(int)(years*12)-1;i>0;i--) {
			balance = printMonthlyData(i,monthly_payment,monthly_interest,balance);
		}
		
		
	}

}

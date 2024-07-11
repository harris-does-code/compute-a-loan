/*Name: Amber Harris
 *Project: Compute Loan
 *Last date edited: 2/5/2024
 *
 *The program will calculate loan information from user input. 
 *The user will enter the loan amount, the length of the loan 
 *in years, and the annual interest rate for the loan. The 
 *program will output the interest rate incremented by 0.25, 
 *but only up to twice the original rate. Based on the 
 *incremented interest rate, the program will also output 
 *a monthly payment and the total for the loan based on the
 *loan duration.
 **/

// Import scanner and create main method
import java.util.Scanner;

public class Harris_ComputeLoan {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)){
		
		// Initialize variables for user inputs for loan amount, duration of the loan, and annual interest rate
		double totalLoanAmount;
		int loanDuration;
		double annualInterestRate;
		
		System.out.print("Welcome to the Loan Computation System!\n");
		System.out.println();
		
		// User enters loan amount. Entry validates if it is < $1000.
		System.out.print("Please enter your requested Loan Amount in $: ");
		totalLoanAmount = input.nextDouble();
		while ((int)(totalLoanAmount) < 1000) {
			System.out.print("Loan Amount must be >= $1000. Try again! ");
			totalLoanAmount = input.nextDouble();
			System.out.println();
		}
		
		// User enters duration for the loan. Entry validates if it is < 1.
		System.out.print("Please enter the duration of the Loan (in years): ");
		loanDuration = input.nextInt();
		while (loanDuration < 1) {
			System.out.print("Loan duration must be >= 1. Try again!");
			loanDuration = input.nextInt();
			System.out.println();
		}
		
		// User enters annual interest rate. Entry validates if it is < 2.
		System.out.print("Please enter the desired annual interest rate: ");
		annualInterestRate = input.nextDouble();
		while ((int)(annualInterestRate) < 2) {
			System.out.print("Interest rate must be >= 2. Try again!");
			annualInterestRate = input.nextDouble();
			System.out.println();
		}
		
		// Convert the annual interest rate to a percent from a float-point number
		double interestAsPercent = annualInterestRate / 100;
		
		// Calculate the monthly interest rate
		double monthlyInterestRate = (totalLoanAmount * interestAsPercent) / 12;
		
		// Calculate the monthly payment
		double monthlyPaymentWithInterest = monthlyInterestRate + (totalLoanAmount / (loanDuration * 12));
		
		// Calculate the total payment for the loan
		double totalPaymentForLoan = (monthlyPaymentWithInterest * 12) * loanDuration;
		
		// Find twice the annual interest rate
		double incrementInterestRate = annualInterestRate;
		double doubleInterestRate = Math.ceil(annualInterestRate) * 2;
		
		// Display header for output
		System.out.print("\nInt Rate %\tMonthly $ Amount\tTotal Payment on Loan\n");
		System.out.print("--------------------------------------------------------------\n");
		System.out.printf("%-4s%4.2f%1s", " ", (double)(annualInterestRate), "%");
		System.out.printf("%-11s%4.2f", " ", monthlyPaymentWithInterest);
		System.out.printf("%-20s%5.2f", " ", totalPaymentForLoan);
		System.out.println();
		
		// Use do-while loop to output the incremented annual interest rate, monthly payment amount, and total payment for the loan
		// Loop will iterate until the annual interest rate is double its original amount
		do {
			incrementInterestRate += 0.25;
			monthlyInterestRate = ((incrementInterestRate / 100) * totalLoanAmount) / 12;
			monthlyPaymentWithInterest = monthlyInterestRate + (totalLoanAmount / (loanDuration * 12));
			totalPaymentForLoan = (monthlyPaymentWithInterest * 12) * loanDuration;
			System.out.printf("%-4s%4.2f%1s", " ", incrementInterestRate, "%");
			System.out.printf("%-11s%4.2f", " ", monthlyPaymentWithInterest);
			System.out.printf("%-20s%5.2f", " ", totalPaymentForLoan);
			System.out.println();
		}while(incrementInterestRate < doubleInterestRate);
	
		}

	}

}

package root.calculation.strategy;

import root.calculation.response.LoanCalculationResponse;
import root.calculation.utils.CalculationUtils;
import root.calculation.utils.FinanceUtils;
import root.loan.Loan;

public class HousingLoanCalculationStrategy implements LoanCalculationStrategy {

    @Override
    public LoanCalculationResponse calculateLoan(Loan loan) {
        double loanAmount = loan.getLoanAmount();
        int loanPeriod = loan.getLoanPeriodInMonth();
        double monthRate = CalculationUtils.yearRateToMonthRate(loan.getInterestRate());
        double balance = loanAmount;

        LoanCalculationResponse loanCalculationResponse = new LoanCalculationResponse();

        for(int i = 1; i <= loanPeriod; i++){
            double payment = CalculationUtils.getPositiveNumber(
                    FinanceUtils.getPayment(monthRate, i, loanPeriod, loanAmount, 0.0, 0));

            double loanRepayment = CalculationUtils.getPositiveNumber(
                    FinanceUtils.getLoanRepayment(monthRate, i, loanPeriod, loanAmount, 0.0, 0));

            double interestPayment = CalculationUtils.getPositiveNumber(
                    FinanceUtils.getInterestPayment(monthRate, i, loanPeriod, loanAmount, 0.0, 0));

            loanCalculationResponse
                    .addResponse(i, balance, payment, loanRepayment, interestPayment, balance - loanRepayment);

            balance -= loanRepayment;
        }

        return loanCalculationResponse;
    }
}

package root.calculation.strategy;

import root.calculation.response.LoanCalculationResponse;
import root.loan.Loan;

public interface LoanCalculationStrategy {

    LoanCalculationResponse calculateLoan(Loan loan);
}

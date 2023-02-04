package root.loan;

public abstract class Loan {

    private LoanType loanType;

    public abstract double getLoanAmount();

    public abstract double getInterestRate();

    public abstract int getLoanPeriodInMonth();

    public Loan(LoanType loanType) {
        this.loanType = loanType;
    }

    public LoanType getLoanType() {
        return loanType;
    }
}

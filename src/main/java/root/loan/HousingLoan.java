package root.loan;

public class HousingLoan extends Loan {

    private final Double loanAmount;

    private final Double interestRate;

    private final Integer loanPeriod;

    public HousingLoan(Double loanAmount, Double interestRate, Integer loanPeriod) {
        super(LoanType.HOUSING);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanPeriod = loanPeriod;
    }

    @Override
    public double getLoanAmount() {
        return loanAmount;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public int getLoanPeriodInMonth() {
        return loanPeriod * 12;
    }

    @Override
    public String toString() {
        return "HousingLoan{" +
                "loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", loanPeriod=" + loanPeriod +
                '}';
    }
}

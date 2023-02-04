package root.calculation.response;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LoanCalculationResponse {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private List<Response> responses = new ArrayList<>();

    public void addResponse(int period, double  beginningBalance, double payment, double loanRepayment, double interestPayment, double  endingBalance){
        responses.add(new Response(period, beginningBalance,loanRepayment, interestPayment, payment, endingBalance));
    }

    public void showResult(){
        System.out.println("\nResult:");
        for(int i = 0; i < responses.size(); i++){
            Response r = responses.get(i);
            System.out.println("|" +
                    "Period= " + r.period +
                    " | BeginningBalance = " + df.format(r.beginningBalance) +
                    " | Payment = " + df.format(r.payment) +
                    " { LoanRepayment = " + df.format(r.loanRepayment) +
                    ", InterestPayment = " + df.format(r.interestPayment) +
                    " } EndingBalance = " + df.format(r.endingBalance) +
                    " |");
        }
    }

    public List<Response> getResponses() {
        return responses;
    }

    public class Response {

        final int period;

        final double beginningBalance;

        final double loanRepayment;

        final double interestPayment;

        final double payment;

        final double endingBalance;

        public Response(int period, double beginningBalance, double loanRepayment, double interestPayment, double payment, double remainingToPay) {
            this.period = period;
            this.beginningBalance = beginningBalance;
            this.loanRepayment = loanRepayment;
            this.interestPayment = interestPayment;
            this.payment = payment;
            this.endingBalance = remainingToPay;
        }

        public int getPeriod() {
            return period;
        }

        public double getBeginningBalance() {
            return beginningBalance;
        }

        public double getLoanRepayment() {
            return loanRepayment;
        }

        public double getInterestPayment() {
            return interestPayment;
        }

        public double getPayment() {
            return payment;
        }

        public double getEndingBalance() {
            return endingBalance;
        }
    }
}

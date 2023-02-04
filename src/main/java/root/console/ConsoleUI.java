package root.console;

import root.calculation.CalculationService;
import root.loan.HousingLoan;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class ConsoleUI {
    public static String command;

    public static Scanner sc = new Scanner(System.in);

    static Double rate = 3.5;

    static CalculationService calculationService;

    public ConsoleUI(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public void launchConsoleUI(){
        showInfo();
        commandSwitch();
    }

    private static void commandSwitch(){
        setCommand();
        while (!command.equals("exit")) {
            switch (command) {
                case "help": {
                    showCommands();
                    setCommand();
                    break;
                }
                case "houseloan": {
                    String loanAmountMessage = "Please input desired amount:";
                    String amountSupportMessage = "(Input data example: 5000)";

                    System.out.println(loanAmountMessage);
                    double loanAmount = getDoubleFromInputString(sc.nextLine(), loanAmountMessage, amountSupportMessage);

                    String loanPeriodMessage = "Please input Loan period in years:";

                    System.out.println(loanPeriodMessage);
                    int loanPeriod = getIntegerFromInputString(sc.nextLine(), loanPeriodMessage);

                    HousingLoan housingLoan = new HousingLoan(loanAmount,rate,loanPeriod);
                    calculationService.getLoanCalculation(housingLoan).showResult();

                    setCommand();
                    break;
                }
                default: {
                    System.out.println("Wrong command!");
                    showCommands();
                    setCommand();
                    break;
                }
            }
        }
        System.out.println(" ");
        System.out.println("Goodbye!");
        System.out.println("Thank you for using our app!");
    }

    private static void setCommand(){
        System.out.print("Input command:");
        command = sc.nextLine();
    }

    private static void showCommands(){
        System.out.println("Command list: ");
        System.out.println("help: Show available commands.");
        System.out.println("houseloan: Request calculation for Housing Loan.");
        System.out.println("exit: Exit from the application.");
        System.out.println(" ");
    }

    private static void showInfo() {
        System.out.println(" ");
        System.out.println("Housing Loan Calculator");
        System.out.println("Important: The default interest rate used for the calculation is 3.5%");
        System.out.println("Input data for calculation: amount, payback time in years.");
        System.out.println(" ");
        showCommands();
    }

    private static double getDoubleFromInputString(String str, String info, String supportMessage) {
        double res;
        while(true){
            try{
                if(NumberUtils.isDigits(str)){
                    res = Double.valueOf(str);
                    break;
                }else{
                    throw new ConsoleUIException("Incorrect input data", str, supportMessage);
                }
            }
            catch (ConsoleUIException e) {
                System.out.println(e.getMessage() + ": " + e.getValue());
                System.out.println(e.getSupportMessage());
                System.out.println(info);
                str = sc.nextLine();
            }catch (Exception e){
                System.out.println("Incorrect input data: " + str);
                System.out.println("(Input data example: 5)");
                System.out.println(info);
                str = sc.nextLine();
            }
        }
        return res;
    }

    private static int getIntegerFromInputString(String str, String info){
        int res;
        while(true){
            try{
                res = Integer.parseInt(str);
                break;
            }
            catch (Exception e) {
                System.out.println("Incorrect input data: " + str);
                System.out.println("(Input data example: 5)");
                System.out.println(info);
                str = sc.nextLine();
            }
        }
        return res;
    }
}

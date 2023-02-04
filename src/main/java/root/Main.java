package root;

import root.calculation.CalculationService;
import root.console.ConsoleUI;

public class Main {

    private static final ApplicationContext applicationContext = new ApplicationContext();

    private static final CalculationService calculationService =
            new CalculationService(applicationContext.getCalculationStrategyForLoanType());

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI(calculationService);
        consoleUI.launchConsoleUI();
    }
}
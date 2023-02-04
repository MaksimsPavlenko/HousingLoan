package root.console;

public class ConsoleUIException extends Exception{

    private String value;

    private String supportMessage;

    public ConsoleUIException(String message, String value, String supportMessage) {
        super(message);
        this.value = value;
        this.supportMessage = supportMessage;
    }

    public String getValue() {
        return value;
    }

    public String getSupportMessage() {
        return supportMessage;
    }
}

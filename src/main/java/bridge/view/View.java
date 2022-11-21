package bridge.view;

public class View {

    private static final String ERROR = "[ERROR] ";

    protected void print(String message) {
        System.out.println(message);
    }

    protected void print() {
        System.out.println();
    }

    protected void printError(String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }
}

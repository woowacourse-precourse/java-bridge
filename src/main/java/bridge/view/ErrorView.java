package bridge.view;

public class ErrorView {

    public static void printErrorMessage(RuntimeException exception) {
        System.out.println(String.format("[ERROR] %s", exception.getMessage()));
    }
}

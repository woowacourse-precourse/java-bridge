package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        try {
            inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

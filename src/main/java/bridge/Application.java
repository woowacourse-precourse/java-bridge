package bridge;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();

        int size = 0;
        while (size == 0) {
            try {
                outputView.printInputBridgeSize();
                size = inputView.readBridgeSize();

                System.out.println(size);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

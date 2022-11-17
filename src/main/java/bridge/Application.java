package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            inputView.readBridgeSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

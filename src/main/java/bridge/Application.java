package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int bridgeSize = inputView.readBridgeSize();
        String moveSpaceAnswer = inputView.readMoving();

        System.out.println(moveSpaceAnswer);
    }
}

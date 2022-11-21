package bridge;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Message.startGameMessage();
        inputView.inputBridge();
    }

}

package bridge;

public class Application {

    public static void main(String[] args) {
       OutputView outputView = new OutputView();
       outputView.printStartMessage();

       InputView inputView = new InputView();
       inputView.readBridgeSize();
    }
}

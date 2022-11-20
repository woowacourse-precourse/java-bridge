package bridge;

public class Application {

    public static void main(String[] args) {
    	OutputView outputView = new OutputView();
    	outputView.viewGameStartMessage();
//    	outputView.viewInputSizeMessage();
        InputView inputView = new InputView();
        inputView.checkBridgeValidate();
    }
}

package bridge;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame(){
        outputView.printMessage(Message.START);
        outputView.enterLine();
        int bridgeSize = inputView.readBridgeSize();
        validate(bridgeSize);
    }

    public void validate(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_RANGE.getMessage());
        }
    }


}

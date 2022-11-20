package bridge;

public class GameController {
    private BridgeMaker bridgeMaker;
    private int size = 0;
    InputView inputView = new InputView();
    public void startGame() {
        try {
            inputView.printStartGame();
            setBridgeSize();
            setMoving();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void setBridgeSize() throws IllegalArgumentException {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String input = inputView.readBridgeSize();
        size = Validator.convertNumeric(input);
        Validator.validateBridgeSize(size);
        bridgeMaker.makeBridge(size);
    }

    public void setMoving() throws IllegalArgumentException {
        for (int index = 0; index < size; index++) {
            String input = inputView.readMoving();
            Validator.checkUpOrDown(input);
        }
    }
}

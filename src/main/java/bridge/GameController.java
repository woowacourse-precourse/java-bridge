package bridge;

public class GameController {
    private BridgeMaker bridgeMaker;
    InputView inputView = new InputView();
    public void startGame() {
        inputView.printStartGame();
        setBridgeSize();
    }

    public void setBridgeSize() {
        try {
            bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            String input = inputView.readBridgeSize();
            int size = Validator.convertNumeric(input);
            Validator.validateBridgeSize(size);
            bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }


}

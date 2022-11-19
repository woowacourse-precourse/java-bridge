package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Direction;
import bridge.model.GameBoard;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGameStart();

        BridgeGame bridgeGame = new BridgeGame(createBridge(), new Player());
        GameBoard gameBoard = new GameBoard();
    }

    private static BridgeSize inputBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            return new BridgeSize(size);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static Bridge createBridge() {
        BridgeSize bridgeSize = inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private static Direction inputDirection() {
        try {
            return Direction.fromInput(inputView.readDirection());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputDirection();
        }
    }
}

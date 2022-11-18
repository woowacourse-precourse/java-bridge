package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void setBridgeSize() {
        try {
            outputView.printBridgeSizeInput();
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            System.out.println(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            setBridgeSize();
        }
    }

    public void setMove() {
        try {
            outputView.printMoveInput();
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.move(inputView.readMoving());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            setMove();
        }
    }

}

package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.DataTypeChanger;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    DataTypeChanger dataTypeChanger = new DataTypeChanger();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    private BridgeGame create() {
        outputView.printStartBridgeGame();
        outputView.printBridgeLengthQuestion();
        String bridgeSize = inputView.readBridgeSize();
        int size = dataTypeChanger.StringToInteger(bridgeSize);
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }
    private void play(BridgeGame bridgeGame, User user) {
        while (!user.getQuit() && !bridgeGame.comparePositionLength()) {
            outputView.printMoveToWhereQuestion();
            String moveInput = inputView.readMoving();
            checkCorrect(moveInput, bridgeGame, user);
        }
        printResult(bridgeGame, user);
    }
}

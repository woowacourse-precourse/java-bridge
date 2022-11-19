package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.Square;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        outputView.printInit();
        int size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker =  new BridgeMaker(generator);
        List<String> tempBridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        Bridge bridge = Bridge.valueOf(tempBridge);

        String move = inputView.readMoving();
        Square userMove = new Square(move);

        int position = bridgeGame.getPosition();
        boolean result = bridge.canMoveForward(userMove, position);
        if (result) {
            bridgeGame.move();
        }

        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.updateResult(userMove, result);

        List<String> upBridgeResult = bridgeResult.getUpBridgeResult();
        List<String> downBridgeResult = bridgeResult.getDownBridgeResult();

        outputView.printMap(upBridgeResult, downBridgeResult);

        if (bridgeGame.isGameSuccess()) {
            //OutputView.printResult();
        }
    }
}

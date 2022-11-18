package bridge.system.controller;

import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;

import java.util.Iterator;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        Iterator<String> bridgeIter = bridge.toIterator();

        outputView.printAskingNextStepMessage();
        String nextMove = inputView.readMoving();

        boolean result = bridgeGame.move(nextMove, bridgeIter);
    }
}

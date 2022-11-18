package bridge.system.controller;

import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;
import bridge.vo.BridgeStep;

import java.util.Iterator;
import java.util.List;

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

        List<BridgeStep> bridgeSteps = BridgeStep.from(bridgeMaker.makeBridge(bridgeSize));
        Bridge bridge = new Bridge(bridgeSteps);
        Iterator<BridgeStep> bridgeIter = bridge.toIterator();

        outputView.printAskingNextStepMessage();
        BridgeStep nextMove = BridgeStep.getByValue(inputView.readMoving());

        boolean result = bridgeGame.move(nextMove, bridgeIter);
    }
}

package bridge.controller;


import bridge.domain.BridgeGame;
import bridge.domain.StageResult;
import bridge.generator.BridgeMaker;
import bridge.validator.Unit;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void initBridge() {
        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGame = new BridgeGame(bridge);
    }

    public void processGame() {
        String userInput = inputView.readMoving();

        StageResult stageResult = bridgeGame.processStage(userInput);
        if(stageResult == StageResult.FAIL) {
            processFail();
        }
        if(stageResult == StageResult.SUCCESS) {
            processSuccess();
        }
    }
}

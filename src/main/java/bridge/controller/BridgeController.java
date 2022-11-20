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

    public void initBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        initBridgeGame();

        StageResult stageResult = StageResult.PASS;

        while (stageResult == StageResult.PASS) {
            processGame();
        }
    }

    public void processGame() {
        String userInput = inputView.readMoving();

        StageResult stageResult = bridgeGame.processStage(userInput);

        processResult(stageResult);
    }


    public void processResult(StageResult result) {
        if(result == StageResult.PASS) {
            pass();
        }
        if(result == StageResult.FAIL) {
            fail();
        }
        if(result == StageResult.SUCCESS) {
            success();
        }
    }

    public void pass() {
        bridgeGame.pass();
    }

    public void fail() {
        String userInput = inputView.readGameCommand();

        if(userInput.equals(Unit.RETRY.getCommand())) {
            bridgeGame.retry();
        }

        if(userInput.equals(Unit.QUITE.getCommand())) {
            throw new IllegalArgumentException();
        }
    }

    public void success() {
        throw new IllegalArgumentException();
    }
}

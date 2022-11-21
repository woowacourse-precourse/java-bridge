package bridge.controller;


import bridge.Exception.QuitGameException;
import bridge.Exception.SuccessGameException;
import bridge.domain.BridgeGame;
import bridge.domain.StageResult;
import bridge.generator.BridgeMaker;
import bridge.validator.Unit;
import bridge.view.InputView;
import bridge.view.Messages;
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

    public void initBridgeGame(List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
    }

    public List<String> createBridge() {
        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }

    public void playWithExceptionCatch() {
        try {
            play();
        } catch (QuitGameException e) {
            quitGame();
        } catch (SuccessGameException e) {
            successGame();
        }
    }

    public void play() {
        List<String> bridge = createBridge();
        initBridgeGame(bridge);
        outputView.printMessage(Messages.VIEW_START_GAME);

        while (true) {
            processGame();
        }
    }

    public void processGame() {
        String userInput = inputView.readMoving();

        StageResult stageResult = bridgeGame.move(userInput);

        outputView.printMap(userInput, stageResult);

        processResult(stageResult);
    }


    public void processResult(StageResult result) {
        if (result == StageResult.PASS) {
            bridgeGame.pass();
        }
        if (result == StageResult.FAIL) {
            decideRetryOrQuit();
        }
        if (result == StageResult.SUCCESS) {
            bridgeGame.success();
        }
    }

    public void decideRetryOrQuit() {
        String userInput = inputView.readGameCommand();

        if (userInput.equals(Unit.RETRY.getCommand())) {
            outputView.resetMap();
            bridgeGame.retry();
        }

        if (userInput.equals(Unit.QUITE.getCommand())) {
            bridgeGame.quit();
        }
    }

    public void quitGame() {
        outputView.printResult(StageResult.FAIL);
    }

    public void successGame() {
        outputView.printResult(StageResult.SUCCESS);
    }
}

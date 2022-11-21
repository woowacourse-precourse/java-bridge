package bridge.controller;


import bridge.Exception.QuitGameException;
import bridge.Exception.SuccessGameException;
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

    public void playWithExceptionCatch() {
        try {
            play();
        } catch (QuitGameException e) {
            quitGame();
        }catch (SuccessGameException e) {
            successGame();
        }
    }

    public void play() {
        initBridgeGame();

        while(true) {
            processGame();
        }
    }

    public void processGame() {
        String userInput = inputView.readMoving();

        StageResult stageResult = bridgeGame.processStage(userInput);
        outputView.printMap(userInput, stageResult);
        processResult(stageResult);
    }


    public void processResult(StageResult result) {
        if(result == StageResult.PASS) {
            bridgeGame.pass();
        }
        if(result == StageResult.FAIL) {
            decideRetryOrQuit();
        }
        if(result == StageResult.SUCCESS) {
            bridgeGame.success();
        }
    }

    public void decideRetryOrQuit() {
        String userInput = inputView.readGameCommand();

        if(userInput.equals(Unit.RETRY.getCommand())) {
            bridgeGame.retry();
        }

        if(userInput.equals(Unit.QUITE.getCommand())) {
            bridgeGame.quit();
        }
    }

    public void quitGame() {
        System.out.println("quit game");
    }

    public void successGame() {
        System.out.println("success game");
    }
}

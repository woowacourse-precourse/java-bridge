package bridge.controller;

import bridge.config.BridgeGameConfig;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    private boolean isPlaying = true;

    public BridgeGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play(){
        while(isPlaying){
            makeBridge();
            move();
            showResult();
            checkRetry();
        }
    }

    private void showResult() {
        outputView.printResult();
    }

    private void checkRetry() {
        String command = inputView.readGameCommand();
        if(command.equals(BridgeGameConfig.GAME_RETRY)) {
            bridgeGame.retry();
            return;
        }
        if(command.equals(BridgeGameConfig.GAME_EXIT)) {
            isPlaying = false;
        }
    }

    private void move() {
        while(!isAnswer()) {
            String inputMoving = inputView.readMoving();
            bridgeGame.move(inputMoving);
            outputView.printMap(inputMoving);
        }
    }

    private boolean isAnswer() {
        return bridgeGame.correctAnswer();
    }

    private void makeBridge() {
        int size = inputView.readBridgeSize();
        List<String> rawAnswerBridge = bridgeMaker.makeBridge(size);
        Bridge answerBridge = new Bridge(rawAnswerBridge);
        bridgeGame.setAnswerBridge(answerBridge);
    }
}

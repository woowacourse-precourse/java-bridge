package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.BridgeGameCommand.COMMAND_GAME_QUIT;
import static bridge.config.BridgeGameCommand.COMMAND_GAME_RETRY;

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

    public void play() {
        makeBridge();
        move();
        showResult();
    }

    private void makeBridge() {
        outputView.printStart();
        outputView.printInputLength();

        int size = inputView.readBridgeSize();
        List<String> rawAnswerBridge = bridgeMaker.makeBridge(size);
        Bridge answerBridge = new Bridge(rawAnswerBridge);
        Bridge currentBridge = new Bridge(new ArrayList<>());
        bridgeGame.setUp(answerBridge, currentBridge);
    }

    private void move() {
        while (isPlaying && !isAnswer()) {
            outputView.printInputMoving();
            String inputMoving = inputView.readMoving();
            bridgeGame.move(inputMoving);
            outputView.printMap(bridgeGame.getCurrentBridge(), bridgeGame.getAnswerBridge());
            if (!checkCurrentState()) {
                checkRetry();
            }
        }
    }

    private void checkRetry() {
        outputView.printGameCommand();
        String command = inputView.readGameCommand();
        if (command.equals(COMMAND_GAME_RETRY)) {
            bridgeGame.retry();
            return;
        }
        if (command.equals(COMMAND_GAME_QUIT)) {
            isPlaying = false;
        }
    }

    private boolean checkCurrentState() {
        return bridgeGame.checkCurrentState();
    }

    private void showResult() {
        outputView.printResult(bridgeGame);
    }

    private boolean isAnswer() {
        return bridgeGame.checkAnswer();
    }
}

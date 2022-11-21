package bridge.controller;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.BridgeGameCommand.COMMAND_GAME_EXIT;
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
        outputView.printInputLength();

        int size = inputView.readBridgeSize();
        List<String> rawAnswerBridge = bridgeMaker.makeBridge(size);
        Bridge answerBridge = new Bridge(rawAnswerBridge);
        Bridge currentBridge = new Bridge(new ArrayList<>());
        bridgeGame.setUp(answerBridge, currentBridge);

        outputView.printStart();
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
        if (command.equals(COMMAND_GAME_EXIT)) {
            isPlaying = false;
        }
    }

    /**
     * 현재까지 이동해온 다리가 정답의 일부분인지 확인한다.
     *
     * @return 정답의 일부분이라면 true
     */
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

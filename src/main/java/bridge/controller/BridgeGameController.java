package bridge.controller;

import static bridge.command.GameCommand.*;
import static bridge.util.Constant.*;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;
import java.util.List;

public class BridgeGameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private String userInput;

    public BridgeGameController(View view, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = view.getInputView();
        this.outputView = view.getOutputView();
        this.bridgeGame = bridgeGame;
    }

    // 게임을 최종적으로 진행하는 기능
    public void run() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        playGame(bridge);
    }

    // 한 게임을 진행하는 기능
    private void playGame(List<String> bridge) {
        do {
            bridgeGame.increaseGameAttemptCount();
            bridgeGame.retry();
            playRound(bridge);
        } while (isRetry(bridge, userInput));
        outputView.printResult(bridgeGame, userInput, bridge);
    }


    // 한 라운드를 진행하는 기능
    private void playRound(List<String> bridge) {
        do {
            userInput = inputView.readMoving();
            bridgeGame.move(userInput, bridge);
            bridgeGame.increaseRoundCount();
            outputView.printMap(bridgeGame);
        } while (bridgeGame.checkPlayNextRound(userInput, bridge));
    }

    // 재시작 기능
    private boolean isRetry(List<String> bridge, String userInput) {
        if (bridgeGame.checkGameSuccess(userInput, bridge).equals(SUCCESS)) {
            return false;
        }
        String replay = inputView.readGameCommand();
        if (isRestart(replay)) {
            return true;
        }
        return false;
    }
}
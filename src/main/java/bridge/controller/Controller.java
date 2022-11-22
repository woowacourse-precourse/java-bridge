package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String RETRY = "R";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private GameResult gameResult;

    public void run() {
        System.out.println(GAME_START);
        gameResult = new GameResult(true, 1);

        Bridge answerBridge = makeAnswerBridge(new BridgeMaker(new BridgeRandomNumberGenerator()));

        Bridge playerBridge = playingGame(answerBridge);
        endGame(answerBridge, playerBridge, gameResult);
    }

    private Bridge makeAnswerBridge(BridgeMaker bridgeMaker) {
        Bridge answerBridge = setAnswerBridge(bridgeMaker);
        return answerBridge;
    }

    private Bridge setAnswerBridge(BridgeMaker bridgeMaker) {
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private Bridge playingGame(Bridge answerBridge) {
        List<String> playerInput = new ArrayList<>();
        int inputPosition = 0;
        playerInput = createPlayerBridge(answerBridge, playerInput, inputPosition);
        return new Bridge(playerInput);
    }

    private List<String> createPlayerBridge(Bridge answerBridge, List<String> playerInput, int inputPosition) {
        while (playerInput.size() != answerBridge.getBridge().size()) {
            playerInput.add(readPlayerBridge());
            boolean moveSuccess = moveResult(answerBridge, playerInput, inputPosition); inputPosition++;
            if (!moveSuccess) {
                playerInput = checkRetry(playerInput);
                inputPosition = 0;
            }
            if (!gameResult.getSuccess()) { return playerInput; }
        }
        return playerInput;
    }

    private String readPlayerBridge(){
        String moveMessage = inputView.readMoving();
        return moveMessage;
    }

    private boolean moveResult(Bridge answerBridge, List<String> playerInput, int inputPosition) {
        boolean moveSuccess = bridgeGame.move(answerBridge.getBridge().get(inputPosition),
                playerInput.get(playerInput.size() - 1));
        outputView.printMap(answerBridge.getBridge(), playerInput);
        return moveSuccess;
    }

    private List<String> checkRetry(List<String> playerInput) {
        if (askRetry().equals(RETRY)) {
            gameResult.plusTryCount();
            return bridgeGame.retry();
        }
        gameResult.setSuccess(false);
        return playerInput;
    }

    private String askRetry() {
        String retryMessage = inputView.readGameCommand();
        return retryMessage;
    }

    private void endGame(Bridge answerBridge, Bridge playerBridge, GameResult gameResult) {
        outputView.printResult(playerBridge, answerBridge, gameResult);
    }
}

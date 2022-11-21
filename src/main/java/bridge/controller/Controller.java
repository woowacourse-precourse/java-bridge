package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
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

    public void run() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println(GAME_START);

        Bridge answerBridge = makeAnswerBridge(bridgeMaker);

        Bridge playerBridge = new Bridge(new ArrayList<>());
        GameResult gameResult = new GameResult(true, 1);
        playerBridge = playingGame(playerBridge, answerBridge, gameResult);

    }

    private Bridge makeAnswerBridge(BridgeMaker bridgeMaker) {
        Bridge answerBridge;
        try {
            answerBridge = setAnswerBridge(bridgeMaker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            answerBridge = makeAnswerBridge(bridgeMaker);
        }
        return answerBridge;
    }

    private Bridge setAnswerBridge(BridgeMaker bridgeMaker) {
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private Bridge playingGame(Bridge playerBridge, Bridge answerBridge, GameResult gameResult) {
        try{
            playerBridge = readPlayerBridge(playerBridge, answerBridge, gameResult);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            playerBridge = playingGame(playerBridge, answerBridge, gameResult);
        }
        return playerBridge;
    }

    private Bridge readPlayerBridge(Bridge playerBridge, Bridge answerBridge, GameResult gameResult){
        List<String> playerInput = playerBridge.getBridge();
        int cnt = 0;
        int position;

        while (playerInput.size() != answerBridge.getBridge().size()) {
            String moveMessage = getMoveMessage();
            playerInput.add(moveMessage);
            position = bridgeGame.move(answerBridge.getBridge(), cnt, moveMessage);

            outputView.printMap(answerBridge.getBridge(), playerInput);
            if (cnt == position) {
                playerBridge = retry(playerBridge, answerBridge, gameResult);
                return playerBridge;
            }
            cnt = position;
        }
        return new Bridge(playerInput);
    }

    private String getMoveMessage() {
        String moveMessage;
        try {
            moveMessage = readMoveMessage();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            moveMessage = getMoveMessage();
        }
        return moveMessage;
    }

    private String readMoveMessage() {
        return inputView.readMoving();
    }

    private Bridge retry(Bridge playerBridge, Bridge answerBridge, GameResult gameResult) {
        try {
            playerBridge = checkRetry(playerBridge, answerBridge, gameResult);
        } catch (IllegalArgumentException ex) {
            playerBridge = retry(playerBridge, answerBridge, gameResult);
        }
        return playerBridge;
    }

    private Bridge checkRetry(Bridge playerBridge, Bridge answerBridge, GameResult gameResult) {
        if (askRetry().equals(RETRY)) {
            gameResult.plusTryCount();
            return readPlayerBridge(clearPlayerBridge(), answerBridge, gameResult);
        }
        gameResult.setSuccess(false);
        return playerBridge;
    }

    private String askRetry() {
        String retryMessage;
        try {
            retryMessage = inputView.readGameCommand();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            retryMessage = askRetry();
        }
        return retryMessage;
    }

    private Bridge clearPlayerBridge() {
        return new Bridge(bridgeGame.retry());
    }
}

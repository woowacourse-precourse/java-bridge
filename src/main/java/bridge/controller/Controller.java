package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
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
        System.out.println(answerBridge.getBridge());
        Bridge playerBridge = new Bridge(new ArrayList<>());
        playerBridge = playingGame(playerBridge, answerBridge);
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

    private Bridge playingGame(Bridge playerBridge, Bridge answerBridge) {
        try{
            playerBridge = readPlayerBridge(playerBridge, answerBridge);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            playerBridge = playingGame(playerBridge, answerBridge);
        }
        return playerBridge;
    }

    private Bridge readPlayerBridge(Bridge playerBridge, Bridge answerBridge){
        List<String> playerInput = playerBridge.getBridge();
        int cnt = 0;
        int position;
        while(playerInput.size() != answerBridge.getBridge().size()) {
            // 매칭 하는 부분 따로 빼서 리펙토링
            String moveMessage = getMoveMessage();
            playerInput.add(moveMessage);

            position = bridgeGame.move(answerBridge.getBridge(), cnt, moveMessage);

            outputView.printMap(answerBridge.getBridge(), playerInput);

            // 재시도 추가

            cnt = position;
        }
        // 최종시도 횟수과 최종결과만 전송
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
}

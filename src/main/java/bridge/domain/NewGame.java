package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import bridge.domain.user.User;
import bridge.domain.user.UserMaker;
import bridge.domain.utils.BridgeGame;
import bridge.domain.ui.InputView;
import bridge.domain.ui.OutputView;
import bridge.domain.utils.GameEndingHandler;

import java.util.List;

import static bridge.domain.user.CurrentBridgeElement.*;
import static bridge.domain.utils.GameEndingStatus.RETRY;

public class NewGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final UserMaker userMaker = new UserMaker();
    private final BridgeGame bridgeGame;
    private List<String> answerBridge;
    private User user;
    private final int BRIDGE_SIZE;

    public NewGame() {
        BRIDGE_SIZE = getSizeInput();
        makeBridge();
        makeUser();
        bridgeGame = new BridgeGame(user, answerBridge);

        play();
    }

    private int getSizeInput() {
        outputView.printInitialMessages();
        return inputView.readBridgeSize();
    }

    private void makeBridge() {
        answerBridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
    }

    private void makeUser() {
        user = userMaker.makeUser(BRIDGE_SIZE);
    }

    private void play() {
        String movingResult = "O";
        for (int round = 1; round <= BRIDGE_SIZE && movingResult.equals(CROSS_SUCCEEDED.getElement()); round++) {
            outputView.printMessageToGetSpaceToMove();
            movingResult = bridgeGame.processEachRound(round, inputView.readMoving());
            outputView.printMap(user);
        } // 건널 수 없는 길을 선택해 movingResult가 "X"가 되거나, 모든 다리를 건너 게임을 성공한 경우 반복 중단(-> 게임 중단).

        gameRetryOrExit(new GameEndingHandler(user, bridgeGame), movingResult);
    }

    private void gameRetryOrExit(GameEndingHandler gameEndingHandler, String movingResult) {
        if (gameEndingHandler.getGameEndingStatus(movingResult).equals(RETRY)) {
            play();
        }
    }
}

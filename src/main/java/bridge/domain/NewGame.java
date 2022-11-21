package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import bridge.domain.user.User;
import bridge.domain.user.UserMaker;
import bridge.domain.utils.BridgeGame;
import bridge.domain.ui.InputView;
import bridge.domain.ui.OutputView;

import java.util.List;

import static bridge.domain.user.CurrentBridgeElement.*;
import static bridge.domain.ui.RetryOrQuit.RETRY;

public class NewGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final UserMaker userMaker = new UserMaker();
    private final BridgeGame bridgeGame;
    private List<String> answerBridge;
    private User user;

    public NewGame() {
        int brideSize = getSizeInput();
        makeBridge(brideSize);
        makeUser(brideSize);
        bridgeGame = new BridgeGame(user, answerBridge);

        play();
    }

    private int getSizeInput() {
        outputView.printInitialMessages();
        return inputView.readBridgeSize();
    }

    private void makeBridge(int bridgeSize) {
        answerBridge = bridgeMaker.makeBridge(bridgeSize);
        user = userMaker.makeUser(bridgeSize);
    }

    private void makeUser(int bridgeSize) {
        this.user = userMaker.makeUser(bridgeSize);
    }

    private void play() {
        String movingResult = "O";
        int bridgeSize = user.getBridgeSize();
        for (int round = 1; round <= bridgeSize && movingResult.equals(CROSS_SUCCEEDED.getElement()); round++) {
            outputView.printMessageToGetSpaceToMove();
            movingResult = bridgeGame.processEachRound(round, inputView.readMoving());
            outputView.printMap(user);
        } // 건널 수 없는 길을 선택해 movingResult가 "X"가 되거나, 모든 다리를 건너 게임을 성공한 경우 반복 중단(-> 게임 중단).
        processTasksAfterGameEnds(movingResult);
    }

    private void processTasksAfterGameEnds(String movingResult) {
        // 모든 다리를 건너 게임을 성공한 경우.
        if (movingResult.equals(CROSS_SUCCEEDED.getElement())) {
            handleSucceededSituation();
            return;
        }
        // 건널 수 없는 길을 선택해 movingResult가 "X"가 된 경우.
        handleFailedSituation();
    }

    private void handleSucceededSituation() {
        user.setSucceeded();
        outputView.printResult(user);
    }

    private void handleFailedSituation() {
        outputView.printMessageAfterFailure();
        String response = inputView.readGameCommand();
        if (response.equals(RETRY.getValue())) {
            bridgeGame.retry(user);
            play();
            return;
        }
        outputView.printResult(user);
    }

}
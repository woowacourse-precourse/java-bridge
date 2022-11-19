package bridge.domain;

import bridge.domain.bridgemaking.BridgeMakerImpl;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.domain.bridgemaking.BridgeComponent.*;
import static bridge.ui.InputValue.RESTART;

public class NewGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private final BridgeMakerImpl bridgeMakerImpl = new BridgeMakerImpl();
    private final BridgeGame bridgeGame;
    private List<String> answerBridge;
    private User user;

    public NewGame() {
        int brideSize = getSizeInput();
        makeBridges(brideSize);
        bridgeGame = new BridgeGame(user, answerBridge);

        play();
    }

    private int getSizeInput() {
        outputView.printInitialMessages();
        return inputView.readBridgeSize();
    }

    private void makeBridges(int bridgeSize) {
        answerBridge = bridgeMakerImpl.makeAnswerBridge(bridgeSize);
        user = bridgeMakerImpl.makeNewUser(bridgeSize);
    }

    private void play() {
        String movingResult = "O";
        int bridgeSize = user.getBridgeSize();
        for (int round = 1; round <= bridgeSize && movingResult.equals(CROSS_SUCCEEDED.getComponent()); round++) {
            outputView.printMessageToGetSpaceToMove();
            movingResult = bridgeGame.processEachRound(round, inputView.readMoving());
            outputView.printMap(user);
        } // 건널 수 없는 길을 선택해 movingResult가 "X"가 되거나, 모든 다리를 건너 게임을 성공한 경우 반복 중단(-> 게임 중단).
        processTasksAfterGameEnds(movingResult);
    }

    private void processTasksAfterGameEnds(String movingResult) {
        // 모든 다리를 건너 게임을 성공한 경우.
        if (movingResult.equals(CROSS_SUCCEEDED.getComponent())) {
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
        if (response.equals(RESTART.getValue())) {
            bridgeGame.retry(user);
            play();
            return;
        }
        outputView.printResult(user);
    }

}
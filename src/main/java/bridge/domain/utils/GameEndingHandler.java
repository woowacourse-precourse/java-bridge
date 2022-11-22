package bridge.domain.utils;

import bridge.domain.ui.InputView;
import bridge.domain.ui.OutputView;
import bridge.domain.user.User;

import static bridge.domain.utils.GameEndingStatus.*;
import static bridge.domain.user.CurrentBridgeElement.CROSS_SUCCEEDED;

public class GameEndingHandler {

    private final User user;
    private final BridgeGame bridgeGame;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public GameEndingHandler(User user, BridgeGame bridgeGame) {
        this.user = user;
        this.bridgeGame = bridgeGame;
    }

    public GameEndingStatus getGameEndingStatus(String movingResult) {
        // 모든 다리를 건너 게임을 성공한 경우.
        if (movingResult.equals(CROSS_SUCCEEDED.getElement())) {
            handleSucceededSituation();
            return CLEAR;
        }
        // 건널 수 없는 길을 선택해 movingResult가 "X"가 된 경우.
        return handleFailedSituation();
    }

    private void handleSucceededSituation() {
        user.setSucceeded();
        outputView.printResult(user);
    }

    private GameEndingStatus handleFailedSituation() {
        outputView.printMessageAfterFailure();
        String response = inputView.readGameCommand();
        if (response.equals(QUIT.getValue())) {
            outputView.printResult(user);
            return QUIT;
        }
        bridgeGame.retry();
        return RETRY;
    }
}

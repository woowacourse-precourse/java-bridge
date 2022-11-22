package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.util.BridgeType;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 게임을 관리해주는 역할을 한다.
 */
public class GameManager {
    private List<List<String>> result;
    private int round;
    private int tryCount;
    boolean activation;

    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String X = " X ";
    private static final int ROUND_INITIALIZATION = 0;
    private static final int DOWN_INDEX = BridgeType.DOWN.getNumber();
    private static final int UP_INDEX = BridgeType.UP.getNumber();

    public GameManager() {
        this.result = new ArrayList<>();
        this.round = 0;
        this.tryCount = 1;
        this.activation = true;
    }

    public void start() {
        OutputView.printGameStart();
        int bridgeSize = InputView.getBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        tryGame(bridgeGame, bridgeSize);
        OutputView.printResult(result, isSuccess(result.get(DOWN_INDEX), result.get(UP_INDEX)), tryCount);
    }

    public void tryGame(BridgeGame bridgeGame, int bridgeSize) {
        while (activation) {
            playRound(bridgeGame);
            roundOver(bridgeGame);
            isOver(bridgeSize);
        }
    }

    public void playRound(BridgeGame bridgeGame) {
        String moving = InputView.getMoving();
        result = bridgeGame.move(round, moving);
        OutputView.printMap(result.get(DOWN_INDEX));
        OutputView.printMap(result.get(UP_INDEX));
        round++;
    }

    public void roundOver(BridgeGame bridgeGame) {
        if (result.get(DOWN_INDEX).contains(X) || result.get(UP_INDEX).contains(X)) {
            activation = isRetried();
            bridgeGame.retry();
            round = ROUND_INITIALIZATION;
            upTryCount();
        }
    }

    public void upTryCount() {
        if (activation) {
            tryCount++;
        }
    }

    public void isOver(int bridgeSize) {
        if (round == bridgeSize) {
            activation = false;
        }
    }

    public boolean isRetried() {
        String command = InputView.getGameCommand();
        return Objects.equals(command, "R");
    }

    public String isSuccess(List<String> upResult, List<String> downResult) {
        String success = FAIL;
        if (!upResult.contains(X) && !downResult.contains(X)) {
            success = SUCCESS;
        }
        return success;
    }
}

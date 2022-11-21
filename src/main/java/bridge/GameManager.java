package bridge;

import java.util.ArrayList;
import java.util.Arrays;
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
        OutputView.printResult(result, isSuccess(result.get(0), result.get(1)), tryCount);
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
        OutputView.printMap(result.get(0));
        OutputView.printMap(result.get(1));
        round++;
    }

    public void roundOver(BridgeGame bridgeGame) {
        if (result.get(0).contains(" X ") || result.get(1).contains(" X ")) {
            activation = isRetried();
            bridgeGame.retry();
            round = 0;
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
        String success = "실패";
        if (!upResult.contains(" X ") && !downResult.contains(" X ")) {
            success = "성공";
        }
        return success;
    }
}

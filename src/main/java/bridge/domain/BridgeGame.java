package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private BridgeGameState bridgeGameState;
    private RetryState retryState;
    private int numOfGamePlayed;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGameState = BridgeGameState.NORMAL;
        this.retryState = RetryState.START;
        this.numOfGamePlayed = 0;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public int getNumOfGamePlayed() {
        return numOfGamePlayed;
    }

    public void proceed(InputView inputView, OutputView outputView) {
        while (retryState == RetryState.RETRY || retryState == RetryState.START) {
            numOfGamePlayed++;
            if (subProceed(inputView, outputView)) { return; }
            if (bridgeGameState == BridgeGameState.SUCCESS_AND_END) { return; }
            String gameCommand = inputView.readGameCommand();
            if (gameCommand == null) { return; }
            retryState = this.retry(gameCommand);
        }
    }

    private boolean subProceed(InputView inputView, OutputView outputView) {
        while (bridgeGameState == BridgeGameState.NORMAL) {
            String moving = inputView.readMoving();
            if (moving == null) {
                return true;
            }
            bridgeGameState = this.move(moving);
            outputView.printMap();
        }
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGameState move(String input) {
        return this.bridge.move(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public RetryState retry(String readGameCommand) {
        if (readGameCommand.equals("R")) {
            bridge.init();
            return RetryState.RETRY;
        }
        return RetryState.QUIT;
    }
}

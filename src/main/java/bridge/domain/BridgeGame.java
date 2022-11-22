package bridge.domain;

import java.util.List;

import static bridge.domain.Constants.*;

public class BridgeGame {

    private List<String> bridge;
    private BridgeState bridgeState;
    private BridgeGameState bridgeGameState;

    public BridgeGame(List<String> bridge, BridgeState bridgeState, BridgeGameState bridgeGameState) {
        this.bridge = bridge;
        this.bridgeState = bridgeState;
        this.bridgeGameState = bridgeGameState;
    }

    public void move(String moving) {
        bridgeState.mark(makeBridgeStatus(moving));
        updateGameResult(moving);
        bridgeGameState.countGameRound();
    }

    private void updateGameResult(String moving) {
        if (!isCrossable(moving)) {
            bridgeGameState.lose();
            return;
        }
        bridgeGameState.win();
    }

    private boolean isCrossable(String moving) {
        return moving.equals(bridge.get(bridgeGameState.getGameRound()));
    }

    private BridgeStatus makeBridgeStatus(String moving) {
        if (isCrossable(moving)) {
            return BridgeStatus.valueOfArrowAndMark(moving, O);
        }
        return BridgeStatus.valueOfArrowAndMark(moving, X);
    }

    public boolean retry(String command) {
        if (command.equals(RETRY)) {
            bridgeGameState.initGameRound();
            bridgeGameState.countTotalGameAttempts();
            bridgeState.initBridgeState();
            return true;
        }
        return false;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getTotalGameAttempts() {
        return bridgeGameState.getTotalGameAttempts();
    }

    public boolean isWon() {
        return bridgeGameState.isWon();
    }
}

package bridge.domain.service;

import bridge.domain.resources.bridge.Bridge;
import bridge.domain.resources.GameCommand;
import bridge.domain.resources.Move;
import java.util.Objects;

public class BridgeGame {

    private static final boolean RETRY_FLAG = true;
    private static final boolean QUIT_FLAG = false;

    private final BridgeStateService bridgeStateService;
    private int totalAttempts;

    public BridgeGame() {
        this.bridgeStateService = new BridgeStateService();
        this.totalAttempts = 0;
    }

    public void move(final Bridge bridge, final Move move) {
        bridgeStateService.setCountUp();
        bridgeStateService.compare(move, bridge);
    }

    public boolean retry(final GameCommand gameCommand) {
        String retryOrQuit = gameCommand.getGameCommand();
        if (Objects.equals(retryOrQuit, "R")) {
            return RETRY_FLAG;
        }
        if (Objects.equals(retryOrQuit, "Q")) {
            return QUIT_FLAG;
        }
        return true;
    }

    public void incrementTotalAttempts() {
        ++totalAttempts;
    }

    public int getStepDistance() {
        return bridgeStateService.getInputCount();
    }

    public boolean isSuccess() {
        return bridgeStateService.getFlag();
    }

    public boolean isRetry(final boolean button) {
        if (button == RETRY_FLAG) {
            bridgeStateService.clearBridgeMap();
            return true;
        }
        return false;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    @Override
    public String toString() {
        return bridgeStateService.toString();
    }
}

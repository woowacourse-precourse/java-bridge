package bridge.domain.service;

import bridge.domain.resources.GameCommand;
import bridge.domain.resources.Move;
import bridge.domain.resources.bridge.Bridge;

import java.util.Objects;

public class BridgeGame {

    private static final boolean RETRY = true;
    private static final boolean QUIT = false;

    private final BridgeStateService bridgeStateService;
    private final BridgeMap bridgeMap;
    private int totalAttempts;

    public BridgeGame() {
        this.bridgeStateService = new BridgeStateService();
        this.bridgeMap = new BridgeMap();
        this.totalAttempts = 0;
    }

    public void move(final Bridge bridge, final Move move) {
        bridgeMap.setCountUp();
        bridgeStateService.compare(move, bridge, bridgeMap);
    }

    public boolean retry(final GameCommand gameCommand) {
        String retryOrQuit = gameCommand.getGameCommand();
        if (Objects.equals(retryOrQuit, "R")) {
            return RETRY;
        }
        if (Objects.equals(retryOrQuit, "Q")) {
            return QUIT;
        }
        return true;
    }

    public void incrementTotalAttempts() {
        ++totalAttempts;
    }

    public int getStepDistance(){
        return bridgeMap.getInputCount();
    }

    public boolean isSuccess() {
        return bridgeMap.getFlag();
    }

    public boolean isRetry(final boolean button) {
        if (button == RETRY) {
            bridgeMap.clearBridgeMap();
            return true;
        }
        return false;
    }

    public int totalAttempts() {
        return totalAttempts;
    }

    public String mapService(){
        return bridgeStateService.mapService(bridgeMap);
    }

    @Override
    public String toString() {
        return mapService();
    }
}

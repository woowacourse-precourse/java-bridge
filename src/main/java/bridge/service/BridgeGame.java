package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.CurrentRoute;
import bridge.domain.GameProgress;

public class BridgeGame {

    public static final String RESTART = "R";

    private final Bridge bridge;
    private final CurrentRoute currentRoute;
    private final GameProgress gameProgress;

    public BridgeGame(Bridge bridge, CurrentRoute currentRoute, GameProgress gameProgress) {
        this.bridge = bridge;
        this.currentRoute = currentRoute;
        this.gameProgress = gameProgress;
    }

    public void move(String input) {
        currentRoute.moveNext(input);
    }

    public void retry() {
        currentRoute.clear();
        gameProgress.updateTrialCount();
    }

    public boolean isMovementSuccess() {
        int currentLocationIndex = currentRoute.getCurrentLocationIndex();
        String currentLocation = currentRoute.getCurrentLocation();
        return bridge.isAvailableSquare(currentLocationIndex, currentLocation);
    }

    public void updateGameProgress() {
        if (isLastSquare() && isMovementSuccess()) {
            gameProgress.victoryGame();
        }
    }

    public int getTrialCount() {
        return gameProgress.getTrialCount();
    }

    public boolean isGameSuccess() {
        return gameProgress.isGameSuccess();
    }

    private boolean isLastSquare() {
        int currentLocationIndex = currentRoute.getCurrentLocationIndex();
        return bridge.isLastIndex(currentLocationIndex);
    }
}

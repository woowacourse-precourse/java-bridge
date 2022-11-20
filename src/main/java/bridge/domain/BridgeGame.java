package bridge.domain;

import java.util.ArrayList;

public class BridgeGame {

    private Bridge bridge;
    private CurrentRoute currentRoute;
    private GameProgress gameProgress;

    public void setBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void setGameState() {
        currentRoute = new CurrentRoute(new ArrayList<>());
        gameProgress = new GameProgress();
    }

    public void move(String input) {
        currentRoute.moveNext(input);
    }

    public void retry() {
        currentRoute.initialize();
        gameProgress.updateTrialCount();
    }

    public boolean isMovementSuccess() {
        int currentLocationIndex = currentRoute.getCurrentLocationIndex();
        String currentLocation = currentRoute.getCurrentLocation();
        return bridge.isAvailableSquare(currentLocationIndex, currentLocation);
    }

    public boolean isLastSquare() {
        int currentLocationIndex = currentRoute.getCurrentLocationIndex();
        return bridge.isLastIndex(currentLocationIndex);
    }
}

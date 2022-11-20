package bridge.domain;

import java.util.ArrayList;

public class BridgeGame {

    private Bridge bridge;
    private CurrentRoute currentRoute;
    private int trialCount;

    public void setBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void setCurrentRoute() {
        currentRoute = new CurrentRoute(new ArrayList<>());
    }

    public void setTrialCount() {
        trialCount = 0;
    }

    public void move(String input) {
        currentRoute.moveNext(input);
    }

    public void retry() {
        currentRoute.initialize();
        updateTrialCount();
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

    public int getTrialCount() {
        return trialCount;
    }

    private void updateTrialCount() {
        trialCount++;
    }
}

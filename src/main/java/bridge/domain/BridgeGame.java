package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Command;
import bridge.util.Validation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class BridgeGame {
    private final MovingResult movingResult;
    private int distance = 0;
    private int retryCount = 1;
    private boolean isGame = false;
    private final BridgeMap bridgeMap = new BridgeMap();

    public LinkedHashMap<String, List<String>> getBridgeMap() {
        return bridgeMap.getMap();
    }

    public boolean getIsGame() {
        return isGame;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public BridgeGame(int bridgeLength) {
        try {
            Validation.bridgeLengthValidation(bridgeLength);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeLength);
        this.movingResult = new MovingResult(bridge);
    }

    public void createMap(String moving) {
        bridgeMap.createMap(movingResult.movedResult(moving, distance), moving);
    }


}
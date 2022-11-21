package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int tryCount = 1;
    private int correctAnswerCount = 0;
    private List<String> bridgeRoute = new ArrayList<>();
    private List<String> bridgeMap = new ArrayList<>();

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public void increaseCorrectAnswerCount() {
        correctAnswerCount++;
    }

    public List<String> getBridgeRoute() {
        return bridgeRoute;
    }

    public void insertBridgeRoute(String moving) {
        bridgeRoute.add(moving);
    }

    public List<String> getBridgeMap() {
        return bridgeMap;
    }

    public void insertBridgeMap(String answer) {
        bridgeMap.add(answer);
    }

    public int getTryCount() {
        return tryCount;
    }

    public void resetPlayer() {
        tryCount++;
        correctAnswerCount = 0;
        bridgeRoute = new ArrayList<>();
        bridgeMap = new ArrayList<>();
    }
}

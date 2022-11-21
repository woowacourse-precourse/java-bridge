package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int tryCount = 1;
    private int correctAnswerCount = 0;
    private List<String> bridgeRoute = new ArrayList<>();

    public boolean move(String moving, List<String> bridge) {
        bridgeRoute.add(moving);
        if (bridge.get(correctAnswerCount).equals(moving)){
            correctAnswerCount++;
            return true;
        }
        return false;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public void increaseCorrectAnswerCount(){
        correctAnswerCount++;
    }

    public List<String> getBridgeRoute() {
        return bridgeRoute;
    }

    public void insertBridgeRoute(String moving) {
        bridgeRoute.add(moving);
    }

    public void resetPlayer(){
        tryCount ++;
        correctAnswerCount = 0;
        bridgeRoute = new ArrayList<>();
    }
}

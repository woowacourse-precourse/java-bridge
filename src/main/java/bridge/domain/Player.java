package bridge.domain;

import bridge.dto.Bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Long numberOfTry;
    private List<String> upperBridge;
    private List<String> lowerBridge;
    private final String POSSIBLE = " O ";
    private final String IMPOSSIBLE = " X ";
    private final String EMPTY = "   ";
    private final String BRIDGE_UP = "U";

    public Player() {
        numberOfTry = 1L;
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    public Long getNumberOfTry() {
        return numberOfTry;
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }

    public void movePosition(Bridge bridge, String position) {
        if (canMove(bridge.getPosition(getCurrentPosition()), position)) {
            move(POSSIBLE, position);
            return;
        }
        move(IMPOSSIBLE, position);
    }

    public Boolean isGameOver(Bridge bridge) {
        if (isReachedEnd(bridge.getSize()) || !canKeepMoving()) {
            return true;
        }
        return false;
    }

    public Boolean isGameClear(int bridgeSize) {
        if (isReachedEnd(bridgeSize) && isPathCorrect()) {
            return true;
        }
        return false;
    }

    public void initBridge() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    public void incrementNumberOfTry() {
        numberOfTry = numberOfTry + 1;
    }

    private Boolean isPathCorrect() {
        int currentPosition = getCurrentPosition();

        if (upperBridge.get(currentPosition - 1).equals(POSSIBLE) || lowerBridge.get(currentPosition - 1).equals(POSSIBLE)) {
            return true;
        }
        return false;
    }

    private Boolean canKeepMoving() {
        int currentPosition = getCurrentPosition();

        if (upperBridge.get(currentPosition - 1).equals(POSSIBLE) || lowerBridge.get(currentPosition - 1).equals(POSSIBLE)) {
            return true;
        }
        return false;
    }

    private Boolean isReachedEnd(int bridgeSize) {
        if (bridgeSize == upperBridge.size()) {
            return true;
        }
        return false;
    }

    private void move(String movingResult, String position) {
        if (position.equals(BRIDGE_UP)) {
            upperBridge.add(movingResult);
            lowerBridge.add(EMPTY);
            return;
        }
        upperBridge.add(EMPTY);
        lowerBridge.add(movingResult);
    }

    private Boolean canMove(String currentPosition, String nextPosition) {
        if (currentPosition.equals(nextPosition)) {
            return true;
        }
        return false;
    }

    private int getCurrentPosition() {
        return upperBridge.size();
    }

}
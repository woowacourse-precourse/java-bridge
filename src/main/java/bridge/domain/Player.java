package bridge.domain;

import bridge.dto.Bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Long numberOfTry;
    private List<String> upperBridge;
    private List<String> lowerBridge;
    private final int START_POSITION = 0;
    private final String POSSIBLE = " O ";
    private final String IMPOSSIBLE = " X ";
    private final String EMPTY = "   ";
    private final String BRIDGE_UP = "U";

    public Player() {
        numberOfTry = 0L;
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
        if (isReachedEnd(bridge) || canKeepMoving()) {
            return true;
        }
        return false;
    }

    private Boolean canKeepMoving() {
        int currentPosition = getCurrentPosition();

        if (upperBridge.get(currentPosition).equals(POSSIBLE) || lowerBridge.get(currentPosition).equals(POSSIBLE)) {
            return true;
        }
        return false;
    }

    private Boolean isReachedEnd(Bridge bridge) {
        if (bridge.getSize() == upperBridge.size()) {
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
        int currentPosition = upperBridge.size();
        if (currentPosition == START_POSITION) {
            return currentPosition;
        }
        return currentPosition - 1;
    }

}
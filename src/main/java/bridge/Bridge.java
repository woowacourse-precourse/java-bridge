package bridge;

import static constant.Message.*;
import java.util.List;

public class Bridge {
    public static final int JUST_CROSSED = 1;
    public static final int CAN_CROSS_NEXT = 2;
    public static final int CANNOT_CROSS_NEXT = 3;
    public static final int JUST_CROSSED_AND_CROSS_OVER = 4;

    private final List<String> bridge;
    private int currentIndex;
    private int gameCount;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.currentIndex = -1;
        this.gameCount = 1;
    }



    public int getCurrentIndex() {
        return currentIndex;
    }

    private void move() {
        currentIndex += 1;
    }

    public boolean isGivenIndexUpside(int index) {
        return bridge.get(index).equals(UP);
    }

    public boolean isGivenIndexDownside(int index) {
        return bridge.get(index).equals(DOWN);
    }

    public int isNextMovingPossible(String upperOrLower) {
        move();
        if (bridge.get(getCurrentIndex()).equals(upperOrLower)) {
            return CAN_CROSS_NEXT;
        }
        return CANNOT_CROSS_NEXT;
    }

    public boolean whetherFollowingEndOrNot() {
        return getCurrentIndex() == (bridge.size() - 1);
    }

    public void reset() {
        resetCurrent();
        addGameCount();
    }

    private void addGameCount() {
        this.gameCount += 1;
    }

    private void resetCurrent() {
        this.currentIndex = -1;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int updateMovingResultAndReturnMovingResult(String inputUpOrDown) {
        int result = isNextMovingPossible(inputUpOrDown);
        if (result == CAN_CROSS_NEXT) {
            if (whetherFollowingEndOrNot()) {
                return JUST_CROSSED_AND_CROSS_OVER;
            }
            return JUST_CROSSED;
        }
        return result;
    }



    public String movingResultToString(String successOrNot) {
        return lineToString(successOrNot, UP).concat(NEWLINE)
                .concat(lineToString(successOrNot, DOWN));
    }

    private String lineToString(String successOrNot, String upOrDown) {
        return BRIDGE_BEGIN.concat(createMovingResult(successOrNot, upOrDown))
                .concat(BRIDGE_END);
    }

    private String createMovingResult(String successOrNot, String inputUpOrDown) {
        if (inputUpOrDown.equals(UP)) {
            return getUpperMovableResultBeforeCurrent(getCurrentIndex())
                    .concat(getUpperMovableResult(successOrNot, getCurrentIndex()));
        }

        return getLowerMovableResultBeforeCurrent(getCurrentIndex())
                .concat(getLowerMovableResult(successOrNot, getCurrentIndex()));
    }

    private String getUpperMovableResultBeforeCurrent(int current) {
        StringBuilder movingResult = new StringBuilder();
        for (int index = 0; index < current; index++) {
            movingResult.append(getUpperMovableResult(SUCCESS, index))
                    .append(BRIDGE_DIVIDING_LINE);
        }
        return movingResult.toString();
    }

    private String getLowerMovableResultBeforeCurrent(int current) {
        StringBuilder movingResult = new StringBuilder();
        for (int index = 0; index < current; index++) {
            movingResult.append(getLowerMovableResult(SUCCESS, index))
                    .append(BRIDGE_DIVIDING_LINE);
        }
        return movingResult.toString();
    }

    private String getUpperMovableResult(String successOrNot, int index) {
        if (successOrNot.equals(SUCCESS)) {
            if (isGivenIndexUpside(index)) {
                return CORRECT;
            }
            return EMPTY;
        }
        if(isGivenIndexUpside(index)) {
            return EMPTY;
        }
        return WRONG;
    }

    private String getLowerMovableResult(String successOrNot, int index) {
        if (successOrNot.equals(SUCCESS)) {
            if (isGivenIndexDownside(index)) {
                return CORRECT;
            }
            return EMPTY;
        }
        if(isGivenIndexDownside(index)) {
            return EMPTY;
        }
        return WRONG;
    }
}

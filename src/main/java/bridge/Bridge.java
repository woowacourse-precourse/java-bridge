package bridge;

import static constant.Message.*;
import java.util.List;

public class Bridge {
    public static final int JUST_CROSSED = 1;
    public static final int POSSIBLE_CROSS_NEXT = 2;
    public static final int IMPOSSIBLE_CROSS_NEXT = 3;
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

    public boolean isUpside(int index) {
        return bridge.get(index) == UP;
    }

    public boolean isDownside(int index) {
        return bridge.get(index) == DOWN;
    }

    public int isMovingNextPossible(String upperOrLower) {
        move();
        if (bridge.get(getCurrentIndex()).equals(upperOrLower)) {
            return POSSIBLE_CROSS_NEXT;
        }
        return IMPOSSIBLE_CROSS_NEXT;
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


    /**
     *  비즈니스 로직과 UI 로직을 분리하기 위해
     */
    public int updateMovingResultAndReturnNextMovingPossible(String inputUpOrDown) {
        int result = isMovingNextPossible(inputUpOrDown);
        if (result == POSSIBLE_CROSS_NEXT) {
            if (whetherFollowingEndOrNot()) {
                return JUST_CROSSED_AND_CROSS_OVER;
            }
            return JUST_CROSSED;
        }
        return result;
    }


    /**
     *  @refactor 비즈니스 로직과 UI 로직을 분리하기 위해
     */
    public String movingResultToString(String succesOrNot) {
        return upperLineToString(succesOrNot) + "\n" +
                lowerLineToString(succesOrNot);
    }
    private String upperLineToString(String successOrNot) {
        String upperMovingResult = BRIDGE_BEGIN;
        for (int index = 0; index < getCurrentIndex(); index++) {
            upperMovingResult = appendCrossingInUpperLine(upperMovingResult, index);
        }

        if (successOrNot == SUCCESS) {
            upperMovingResult = appendCrossingInUpperLine(upperMovingResult,
                    getCurrentIndex()) + BRIDGE_END;
        }
        if (successOrNot == FAILURE) {
            upperMovingResult = appendNotCrossingInUpperLine(upperMovingResult,
                    getCurrentIndex()) + BRIDGE_END;
        }
        return upperMovingResult;
    }

    private String lowerLineToString(String successOrNot) {
        String lowerMovingResult = BRIDGE_BEGIN;
        for (int index = 0; index < getCurrentIndex(); index++) {
            lowerMovingResult = appendCrossingInLowerLine(lowerMovingResult, index);
        }

        if (successOrNot == SUCCESS) {
            lowerMovingResult = appendCrossingInLowerLine(lowerMovingResult,
                    getCurrentIndex()) + BRIDGE_END;
        }
        if (successOrNot == FAILURE) {
            lowerMovingResult = appendNotCrossingInLowerLine(lowerMovingResult,
                    getCurrentIndex()) + BRIDGE_END;
        }
        return lowerMovingResult;
    }

    private String appendCrossingInLowerLine(String lowerMovingResult, int index) {
        if (isDownside(index)) {
            lowerMovingResult += CORRECT;
            if (index != getCurrentIndex()) {
                lowerMovingResult += BRIDGE_DIVIDING_LINE;
            }
            return lowerMovingResult;
        }
        lowerMovingResult += EMPTY;
        if (index != getCurrentIndex()) {
            lowerMovingResult += BRIDGE_DIVIDING_LINE;
        }
        return lowerMovingResult;
    }

    private String appendNotCrossingInLowerLine(String lowerMovingResult, int index) {
        if (isDownside(index)) {
            lowerMovingResult += EMPTY;
            if (index != getCurrentIndex()) {
                lowerMovingResult += BRIDGE_DIVIDING_LINE;
            }
            return lowerMovingResult;
        }
        lowerMovingResult += WRONG;
        if (index != getCurrentIndex()) {
            lowerMovingResult += BRIDGE_DIVIDING_LINE;
        }
        return lowerMovingResult;
    }


    private String appendCrossingInUpperLine(String upperMovingResult, int index) {
        if (isUpside(index)) {
            upperMovingResult += CORRECT;
            if (index != getCurrentIndex()) {
                upperMovingResult += BRIDGE_DIVIDING_LINE;
            }
            return upperMovingResult;
        }
        upperMovingResult += EMPTY;
        if (index != getCurrentIndex()) {
            upperMovingResult += BRIDGE_DIVIDING_LINE;
        }
        return upperMovingResult;
    }

    private String appendNotCrossingInUpperLine(String upperMovingResult, int index) {
        if (isUpside(index)) {
            upperMovingResult += EMPTY;
            if (index != getCurrentIndex()) {
                upperMovingResult += BRIDGE_DIVIDING_LINE;
            }
            return upperMovingResult;
        }
        upperMovingResult += WRONG;
        if (index != getCurrentIndex()) {
            upperMovingResult += BRIDGE_DIVIDING_LINE;
        }
        return upperMovingResult;
    }
}

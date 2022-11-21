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
    public String movingResultToString(String successOrNot) {
        return lineToString(successOrNot, UP) + NEWLINE +
                lineToString(successOrNot, DOWN);
    }

    private String lineToString(String successOrNot, String upOrDown) {
        return BRIDGE_BEGIN + createMovingResult(successOrNot, upOrDown)
                + BRIDGE_END;
    }

    private String createMovingResult(String successOrNot, String inputUpOrDown) {
        String movingResult = "";
        if (inputUpOrDown == UP) {
            for (int index = 0; index < getCurrentIndex(); index++) {
                movingResult += getUpperMovableResult(SUCCESS, index) + BRIDGE_DIVIDING_LINE;
            }
            movingResult += getUpperMovableResult(successOrNot, getCurrentIndex());
            return movingResult;
        }

        for (int index = 0; index < getCurrentIndex(); index++) {
            movingResult += getLowerMovableResult(SUCCESS, index) + BRIDGE_DIVIDING_LINE;
        }
        movingResult += getLowerMovableResult(successOrNot, getCurrentIndex());
        return movingResult;
    }

    private String getUpperMovableResult(String successOrNot, int index) {
        if (successOrNot == SUCCESS) {
            if (isUpside(index)) {
                return CORRECT;
            }
            return EMPTY;
        }
        if(isUpside(index)) {
            return EMPTY;
        }
        return WRONG;
    }

    private String getLowerMovableResult(String successOrNot, int index) {
        if (successOrNot == SUCCESS) {
            if (isDownside(index)) {
                return CORRECT;
            }
            return EMPTY;
        }
        if(isDownside(index)) {
            return EMPTY;
        }
        return WRONG;
    }
}

package bridge.domain;

import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import bridge.constant.GameStatus;

public class BridgeMonitor {
    private StringBuilder upperLine;
    private StringBuilder lowerLine;
    private static final String END_BRACKET = "]";
    private static final String BRACKETS = "[]";
    private static final String SPACE = "   ";
    private static final String CORRECT_MOVING = " O ";
    private static final String WRONG_MOVING = " X ";
    private static final String BETWEEN_LINE = "|";

    public BridgeMonitor() {
        this.upperLine = new StringBuilder(BRACKETS);
        this.lowerLine = new StringBuilder(BRACKETS);
    }

    public void record(String moving, GameStatus gameStatusAfterMoving) {
        openBracket();
        if (gameStatusAfterMoving.equals(FAIL)) {
            recordFailOf(moving);
        }
        if (!gameStatusAfterMoving.equals(FAIL)) {
            recordSuccessOf(moving);
        }
        closeBracket();
    }

    public String getPicture() {
        String picture = this.upperLine.toString() + "\n" + this.lowerLine.toString();
        return picture;
    }

    public void turnBackOnce() {
        int lastIndexOfLine = this.upperLine.length() - 1;
        if (lastIndexOfLine > 4) {
            this.upperLine.delete(lastIndexOfLine - 5, lastIndexOfLine - 1);
            this.lowerLine.delete(lastIndexOfLine - 5, lastIndexOfLine - 1);
            return;
        }
        this.upperLine.delete(lastIndexOfLine - 3, lastIndexOfLine);
        this.lowerLine.delete(lastIndexOfLine - 3, lastIndexOfLine);
    }

    private void openBracket() {
        int lastIndexOfLine = getLastIndexOfLine();
        this.upperLine.deleteCharAt(lastIndexOfLine);
        this.lowerLine.deleteCharAt(lastIndexOfLine);
        if (isNotFirstColumn()) {
            addLine();
        }
    }

    private boolean isNotFirstColumn() {
        return getLastIndexOfLine() > 1;
    }

    private int getLastIndexOfLine() {
        return this.upperLine.length() - 1;
    }

    private void addLine() {
        this.upperLine.append(BETWEEN_LINE);
        this.lowerLine.append(BETWEEN_LINE);
    }

    private void closeBracket() {
        this.upperLine.append(END_BRACKET);
        this.lowerLine.append(END_BRACKET);
    }

    private void recordFailOf(String moving) {
        if (moving.equals(UPPER_SIDE)) {
            this.upperLine.append(WRONG_MOVING);
            this.lowerLine.append(SPACE);
        }
        if (moving.equals(LOWER_SIDE)) {
            this.upperLine.append(SPACE);
            this.lowerLine.append(WRONG_MOVING);
        }
    }

    private void recordSuccessOf(String moving) {
        if (moving.equals(UPPER_SIDE)) {
            this.upperLine.append(CORRECT_MOVING);
            this.lowerLine.append(SPACE);
        }
        if (moving.equals(LOWER_SIDE)) {
            this.upperLine.append(SPACE);
            this.lowerLine.append(CORRECT_MOVING);
        }
    }
}

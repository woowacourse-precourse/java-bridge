package bridge.domain;

import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import bridge.constant.GameStatus;

public class BridgeDrawer {
    private StringBuilder upperLine;
    private StringBuilder lowerLine;
    private static final String END_BRACKET = "]";
    private static final String BRACKETS = "[]";
    private static final String EMPTY = "   ";
    private static final String SPACE = " ";
    private static final String CORRECT_MOVING = " O ";
    private static final String WRONG_MOVING = " X ";
    private static final String BETWEEN_LINE = "|";
    private static final String SKETCH_FRAME = "%s\n%s";
    private static final int COLUMN_SIZE_INCLUDING_BETWEEN_LINE = 4;
    private static final int COLUMN_SIZE_EXCLUDING_BETWEEN_LINE = 3;

    public BridgeDrawer() {
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

    public String getSketch() {
        String upperLineSketch = upperLine.toString();
        String lowerLineSketch = lowerLine.toString();
        String sketch = String.format(SKETCH_FRAME, upperLineSketch, lowerLineSketch);
        return sketch;
    }

    public void turnBackOnce() {
        if (haveAlready2Moving()) {
            deleteLastMovingIncludingBetweenLine();
            return;
        }
        deleteLastMovingExcludingBetweenLine();
    }

    private void openBracket() {
        int lastIndexOfLine = getLastIndexOfLine();
        upperLine.deleteCharAt(lastIndexOfLine);
        lowerLine.deleteCharAt(lastIndexOfLine);
        if (isEndWithSpace()) {
            addLine();
        }
    }

    private boolean isEndWithSpace() {
        String upperLineSketch = upperLine.toString();
        return upperLineSketch.endsWith(SPACE);
    }

    private int getLastIndexOfLine() {
        return upperLine.length() - 1;
    }

    private void addLine() {
        upperLine.append(BETWEEN_LINE);
        lowerLine.append(BETWEEN_LINE);
    }

    private void closeBracket() {
        upperLine.append(END_BRACKET);
        lowerLine.append(END_BRACKET);
    }

    private void recordFailOf(String moving) {
        if (moving.equals(UPPER_SIDE)) {
            upperLine.append(WRONG_MOVING);
            lowerLine.append(EMPTY);
        }
        if (moving.equals(LOWER_SIDE)) {
            upperLine.append(EMPTY);
            lowerLine.append(WRONG_MOVING);
        }
    }

    private void recordSuccessOf(String moving) {
        if (moving.equals(UPPER_SIDE)) {
            upperLine.append(CORRECT_MOVING);
            lowerLine.append(EMPTY);
        }
        if (moving.equals(LOWER_SIDE)) {
            upperLine.append(EMPTY);
            lowerLine.append(CORRECT_MOVING);
        }
    }

    private boolean haveAlready2Moving() {
        String upperLineSketch = upperLine.toString();
        return upperLineSketch.contains(BETWEEN_LINE);
    }

    private void deleteLastMovingIncludingBetweenLine() {
        int lastIndexOfLine = getLastIndexOfLine();
        upperLine.delete(lastIndexOfLine - COLUMN_SIZE_INCLUDING_BETWEEN_LINE, lastIndexOfLine);
        lowerLine.delete(lastIndexOfLine - COLUMN_SIZE_INCLUDING_BETWEEN_LINE, lastIndexOfLine);
    }

    private void deleteLastMovingExcludingBetweenLine() {
        int lastIndexOfLine = getLastIndexOfLine();
        upperLine.delete(lastIndexOfLine - COLUMN_SIZE_EXCLUDING_BETWEEN_LINE, lastIndexOfLine);
        lowerLine.delete(lastIndexOfLine - COLUMN_SIZE_EXCLUDING_BETWEEN_LINE, lastIndexOfLine);
    }
}

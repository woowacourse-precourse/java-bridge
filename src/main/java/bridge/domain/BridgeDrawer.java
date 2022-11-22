package bridge.domain;

import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import bridge.constant.GameStatus;

public class BridgeDrawer {
    private final StringBuilder upperLine;
    private final StringBuilder lowerLine;
    private static final String END_BRACKET = "]";
    private static final String BRACKETS = "[]";
    private static final String EMPTY = "   ";
    private static final String SPACE = " ";
    private static final String CORRECT_MOVING = " O ";
    private static final String WRONG_MOVING = " X ";
    private static final String BETWEEN_LINE = "|";
    private static final String PICTURE_FRAME = "%s\n%s";
    private static final int GAP_BETWEEN_INDEX_AND_LENGTH = 1;

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

    public String getPicture() {
        String upperLinePicture = upperLine.toString();
        String lowerLinePicture = lowerLine.toString();
        String picture = String.format(PICTURE_FRAME, upperLinePicture, lowerLinePicture);
        return picture;
    }

    public void reset() {
        upperLine.setLength(0);
        lowerLine.setLength(0);
        upperLine.append(BRACKETS);
        lowerLine.append(BRACKETS);
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
        String upperLinePicture = upperLine.toString();
        return upperLinePicture.endsWith(SPACE);
    }

    private int getLastIndexOfLine() {
        return upperLine.length() - GAP_BETWEEN_INDEX_AND_LENGTH;
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
}

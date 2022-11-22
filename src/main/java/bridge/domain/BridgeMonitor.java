package bridge.domain;

import bridge.constant.GameStatus;

import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.moving.LOWER_SIDE;
import static bridge.constant.moving.UPPER_SIDE;

public class BridgeMonitor {
    private StringBuffer upperLine;
    private StringBuffer lowerLine;
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String BRACKET = "[]";
    private static final String CORRECT_MOVING = " O ";
    private static final String WRONG_MOVING = " X ";
    private static final String SPACE = "   ";
    private static final String MID_LINE = "|";

    public BridgeMonitor(){
        this.upperLine = new StringBuffer(BRACKET);
        this.lowerLine = new StringBuffer(BRACKET);
    }

    public void record(String moving, GameStatus gameStatusAfterMoving){
        int lastIndexOfLine = this.upperLine.length() - 1;
        this.upperLine.deleteCharAt(lastIndexOfLine);
        this.lowerLine.deleteCharAt(lastIndexOfLine);
        if (lastIndexOfLine > 1) {
            this.upperLine.append(MID_LINE);
            this.lowerLine.append(MID_LINE);
        }

        if (gameStatusAfterMoving.equals(FAIL)) {
            if (moving.equals(UPPER_SIDE)) {
                this.upperLine.append(WRONG_MOVING);
                this.lowerLine.append(SPACE);
            }
            if (moving.equals(LOWER_SIDE)) {
                this.upperLine.append(SPACE);
                this.lowerLine.append(WRONG_MOVING);
            }
        }

        if (!gameStatusAfterMoving.equals(FAIL)) {
            if (moving.equals(UPPER_SIDE)) {
                this.upperLine.append(CORRECT_MOVING);
                this.lowerLine.append(SPACE);
            }
            if (moving.equals(LOWER_SIDE)) {
                this.upperLine.append(SPACE);
                this.lowerLine.append(CORRECT_MOVING);
            }
        }
        this.upperLine.append(END_BRACKET);
        this.lowerLine.append(END_BRACKET);
    }

}

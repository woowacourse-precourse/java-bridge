package bridge.model;

import java.util.Stack;

public class MakeMap {
    public static final String START = "[";
    public static final String END = "]";
    public static final String SEPARATOR = "|";
    public static final String CROSS = " O ";
    public static final String FAIL = " X ";
    public static final String SPACE = "   ";

    public String buildMap(Stack<Direction> movement, Bridge bridge) {
        //TODO: 메서드 나누
        StringBuilder upperBuilder = new StringBuilder(START);
        StringBuilder lowerBuilder = new StringBuilder(START);
        int index = 0;
        for (Direction direction : movement) {
            if (index > 0) {
                appendCommonSign(upperBuilder, lowerBuilder, SEPARATOR);
            }
            if (!bridge.canMove(direction, index)) {
                appendFail(upperBuilder, lowerBuilder, direction);
            }
            if (bridge.canMove(direction, index)) {
                appendCross(upperBuilder, lowerBuilder, direction);
                index++;
            }
        }
        appendCommonSign(upperBuilder, lowerBuilder, END);
        return upperBuilder.toString() + System.lineSeparator() + lowerBuilder.toString();
    }

    private void appendCommonSign(StringBuilder upperBuilder, StringBuilder lowerBuilder, String sign) {
        upperBuilder.append(sign);
        lowerBuilder.append(sign);
    }

    private void appendCross(StringBuilder upperBuilder, StringBuilder lowerBuilder, Direction direction) {
        if (direction == Direction.U) {
            upperBuilder.append(CROSS);
            lowerBuilder.append(SPACE);
        }
        if (direction == Direction.D) {
            upperBuilder.append(SPACE);
            lowerBuilder.append(CROSS);
        }
    }

    private void appendFail(StringBuilder upperBuilder, StringBuilder lowerBuilder, Direction direction) {
        if (direction == Direction.U) {
            upperBuilder.append(FAIL);
            lowerBuilder.append(SPACE);
        }
        if (direction == Direction.D) {
            upperBuilder.append(SPACE);
            lowerBuilder.append(FAIL);
        }
    }
}

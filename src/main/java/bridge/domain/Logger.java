package bridge.domain;

public class Logger {
    private static final String NOT_NULL_MESSAGE = "다음 위치에 null 이 들어올 수 없습니다";
    private static final String BLANK_SIGN = "   |";
    private static final String CORRECT_SIGN = " O |";
    private static final String WRONG_SIGN = " X |";
    private final StringBuilder up = new StringBuilder("[");
    private final StringBuilder down = new StringBuilder("[");

    public void put(Position moving, boolean correct) {
        validateMoving(moving);
        if (moving == Position.UP) {
            addOneCheck(up, down, correct);
            return;
        }
        addOneCheck(down, up, correct);
    }

    private void validateMoving(Position moving) {
        if (moving == null) {
            throw new IllegalArgumentException(NOT_NULL_MESSAGE);
        }
    }

    private void addOneCheck(StringBuilder addSign, StringBuilder addSpace, boolean correct) {
        addSpace.append(BLANK_SIGN);
        if (correct) {
            addSign.append(CORRECT_SIGN);
            return;
        }
        addSign.append(WRONG_SIGN);
    }

    public String calculateMap() {
        StringBuilder firstLine = new StringBuilder(up);
        StringBuilder secondLine = new StringBuilder(down);
        firstLine.setCharAt(firstLine.length() - 1, ']');
        secondLine.setCharAt(secondLine.length() - 1, ']');
        return firstLine + "\n" + secondLine;
    }
}

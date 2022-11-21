package bridge.domain;

final class Logger {
    private static final String NOT_NULL_MESSAGE = "다음 위치에 null 이 들어올 수 없습니다";
    private static final String BLANK_SIGN = "   |";
    private static final String CORRECT_SIGN = " O |";
    private static final String WRONG_SIGN = " X |";
    private final StringBuilder up = new StringBuilder("[");
    private final StringBuilder down = new StringBuilder("[");

    public void put(final Position moving, final boolean correct) {
        validateMoving(moving);
        if (moving == Position.UP) {
            addOneCheck(up, down, correct);
            return;
        }
        addOneCheck(down, up, correct);
    }

    private void validateMoving(final Position moving) {
        if (moving == null) {
            throw new IllegalArgumentException(NOT_NULL_MESSAGE);
        }
    }

    private void addOneCheck(final StringBuilder addSign, final StringBuilder addSpace, final boolean correct) {
        addSpace.append(BLANK_SIGN);
        if (correct) {
            addSign.append(CORRECT_SIGN);
            return;
        }
        addSign.append(WRONG_SIGN);
    }

    public String calculateLog() {
        final StringBuilder firstLine = new StringBuilder(up);
        final StringBuilder secondLine = new StringBuilder(down);
        firstLine.setCharAt(firstLine.length() - 1, ']');
        secondLine.setCharAt(secondLine.length() - 1, ']');
        return firstLine + "\n" + secondLine;
    }
}

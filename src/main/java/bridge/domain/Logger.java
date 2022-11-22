package bridge.domain;

/**
 * 우리가 원하는 형태로 결과를 만들어주는 책임을 가지고 있는 클래스
 */
final class Logger {
    private static final String NOT_NULL_MESSAGE = "다음 위치에 null 이 들어올 수 없습니다";
    private static final String BLANK_SIGN = "   |";
    private static final String CORRECT_SIGN = " O |";
    private static final String WRONG_SIGN = " X |";
    private final StringBuilder up = new StringBuilder("[");
    private final StringBuilder down = new StringBuilder("[");

    void put(final Position moving, final boolean correct) {
        validateMoving(moving);
        if (moving == Position.UP) {
            addSign(up, correct);
            addSpace(down);
            return;
        }
        addSign(down, correct);
        addSpace(up);
    }

    private void validateMoving(final Position moving) {
        if (moving == null) {
            throw new IllegalArgumentException(NOT_NULL_MESSAGE);
        }
    }

    private void addSign(final StringBuilder line, final boolean correct) {
        if (correct) {
            line.append(CORRECT_SIGN);
            return;
        }
        line.append(WRONG_SIGN);
    }

    private void addSpace(final StringBuilder line) {
        line.append(BLANK_SIGN);
    }

    String calculateLog() {
        final StringBuilder firstLine = new StringBuilder(up);
        final StringBuilder secondLine = new StringBuilder(down);
        firstLine.setCharAt(firstLine.length() - 1, ']');
        secondLine.setCharAt(secondLine.length() - 1, ']');
        return firstLine + "\n" + secondLine;
    }
}

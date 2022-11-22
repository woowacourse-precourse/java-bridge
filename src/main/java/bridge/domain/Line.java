package bridge.domain;

public enum Line {
    UP(1, "U"), DOWN(0, "D");

    private final int matchingNumber;
    private final String signal;

    Line(int matchingNumber, String signal) {
        this.matchingNumber = matchingNumber;
        this.signal = signal;
    }

    /**
     * 0 또는 1을 받아 Line 에 해당되는 문자열을 반환하는 메서드
     * @param matchingNumber 0 또는 1
     * @return U 또는 D
     */
    public static String mapToSignal(int matchingNumber) {
        return findByMatchingNumber(matchingNumber).signal;
    }

    /**
     * 숫자를 받아 해당 Enum class 를 찾는 메서드
     * @param matchingNumber 0 또는 1
     * @return Enum class
     */
    private static Line findByMatchingNumber(int matchingNumber) {
        if (matchingNumber == UP.matchingNumber) {
            return UP;
        }
        return DOWN;
    }
}

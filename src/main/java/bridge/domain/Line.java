package bridge.domain;

public enum Line {
    UP(1, "U"), DOWN(0, "D");

    private final int matchingNumber;
    private final String signal;

    Line(int matchingNumber, String signal) {
        this.matchingNumber = matchingNumber;
        this.signal = signal;
    }

    public static String mapToSignal(int matchingNumber) {
        return findByMatchingNumber(matchingNumber).signal;
    }

    private static Line findByMatchingNumber(int matchingNumber) {
        if (matchingNumber == UP.matchingNumber) {
            return UP;
        }
        return DOWN;
    }
}

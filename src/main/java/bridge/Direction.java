package bridge;

public enum Direction {
    D, U, NONE;

    public static Direction valueOf(int generate) {
        if (generate == 0) {
            return D;
        }
        if (generate == 1) {
            return U;
        }
        throw new IllegalArgumentException("[ERROR] D, U를 입력하세요.");
    }
}

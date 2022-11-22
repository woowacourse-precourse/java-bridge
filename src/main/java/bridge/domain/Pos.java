package bridge.domain;

public enum Pos {
    D(0), U(1);

    private final int pos;

    Pos(int pos) {
        this.pos = pos;
    }

    public static String findPos(int num) {
        for (Pos o : Pos.values()) {
            if (num == o.pos) {
                return o.name();
            }
        }
        throw new IllegalStateException("BridgeNumberGenerator 를 사용하여 조회 하세요.");
    }
}

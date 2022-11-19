package bridge;

public enum BridgeMove {

    up(1, "U"),
    down(0, "D");

    private final int number;

    private final String moving;

    private BridgeMove(int number, String moving) {
        this.number = number;
        this.moving = moving;
    }

    public int getNumber() {
        return this.number;
    }

    public String getMoving() {
        return this.moving;
    }

    public static String returnMoving(int number) {
        String moving = "";
        if (number == up.number) {
            return up.moving;
        }
        if (number == down.number) {
            return down.moving;
        }
        return moving;
    }
}

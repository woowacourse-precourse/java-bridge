package bridge.utils.constants;

public enum PlayerPosition {
    START_INDEX(-1),
    GO_FRONT_STEP(1);

    private final int value;

    PlayerPosition(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

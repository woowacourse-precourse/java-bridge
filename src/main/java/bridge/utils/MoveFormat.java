package bridge.utils;

public enum MoveFormat {
    MOVE_DOWN("D", 0),

    MOVE_UP("U", 1);

    final String label;
    final int value;

    MoveFormat(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String findLabelByValue(int value) {
        for (MoveFormat moveFormat : MoveFormat.values()) {
            if(moveFormat.value == value) {
                return moveFormat.label;
            }
        }
        throw new IllegalArgumentException();
    }
}

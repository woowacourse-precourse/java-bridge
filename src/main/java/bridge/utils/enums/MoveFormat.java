package bridge.utils.enums;

public enum MoveFormat {
    MOVE_DOWN("D", 0),

    MOVE_UP("U", 1);

    final String label;
    final int value;

    MoveFormat(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public static String findLabelByValue(int value) {
        for (MoveFormat moveFormat : MoveFormat.values()) {
            if (moveFormat.value == value) {
                return moveFormat.label;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isEqual(String label) {
        return this.label.equals(label);
    }
}

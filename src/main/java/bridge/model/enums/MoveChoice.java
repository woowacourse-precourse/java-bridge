package bridge.model.enums;

import java.util.Arrays;

public enum MoveChoice {
    UP("U", 1), DOWN("D", 0);

    public final String moving;
    public final int row;

    MoveChoice(String moving, int row) {
        this.moving = moving;
        this.row = row;
    }

    public String getMoving() {
        return moving;
    }

    public int getRow() {
        return row;
    }

    public static MoveChoice getMatchChoice(String moving){
        return Arrays.stream(MoveChoice.values()).filter((choice) -> choice.moving.equals(moving)).findAny().get();
    }
    public static MoveChoice getMatchChoice(int positionNumber){
        return Arrays.stream(MoveChoice.values()).filter((choice) -> choice.row == positionNumber).findAny().get();
    }
}

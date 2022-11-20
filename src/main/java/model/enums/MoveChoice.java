package model.enums;

import static model.BridgeGameExceptions.NOT_A_MOVE_CHOICE;

import java.util.Arrays;

public enum MoveChoice {
    UP("U", 1), DOWN("D", 0);

    public final String moving;
    public final int positionNumber;

    MoveChoice(String moving, int positionNumber) {
        this.moving = moving;
        this.positionNumber = positionNumber;
    }

    public String getMoving() {
        return moving;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public static MoveChoice getMatchChoice(String moving){
        return Arrays.stream(MoveChoice.values()).filter((choice) -> choice.moving.equals(moving)).findAny().get();
    }
    public static MoveChoice getMatchChoice(int positionNumber){
        return Arrays.stream(MoveChoice.values()).filter((choice) -> choice.positionNumber == positionNumber).findAny().get();
    }
}

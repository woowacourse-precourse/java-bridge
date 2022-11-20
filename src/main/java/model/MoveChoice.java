package model;

import static model.BridgeGameExceptions.NOT_A_MOVE_CHOICE;

import java.util.Arrays;

public enum MoveChoice {
    UP("U", 1), DOWN("D", 0);

    private final String moving;
    private final int positionNumber;

    MoveChoice(String moving, int positionNumber) {
        this.moving = moving;
        this.positionNumber = positionNumber;
    }

    public static String getMoving(int positionNumber) {
    }
}

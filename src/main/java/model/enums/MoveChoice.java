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

    public static String getMoving(int positionNumber) {

        MoveChoice moveChoice = Arrays.stream(MoveChoice.values())
                .filter((choice) -> choice.positionNumber == positionNumber).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_A_MOVE_CHOICE));
        return moveChoice.moving;
    }
}

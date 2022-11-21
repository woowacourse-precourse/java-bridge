package bridge.model.enums;

import java.util.Arrays;

public enum MoveChoice {
    UP("U", 1), DOWN("D", 0);

    private final String movingType;
    private final int numberValue;

    MoveChoice(String movingType, int numberValue) {
        this.movingType = movingType;
        this.numberValue = numberValue;
    }

    public String getMovingType() {
        return movingType;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public static MoveChoice getMatchChoice(String moving){
        return Arrays.stream(MoveChoice.values()).filter((choice) -> choice.movingType.equals(moving)).findAny().get();
    }
    public static MoveChoice getMatchChoice(int positionNumber){
        return Arrays.stream(MoveChoice.values()).filter((choice) -> choice.numberValue == positionNumber).findAny().get();
    }
}

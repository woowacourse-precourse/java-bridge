package bridge.model;

import bridge.standard.GameForm;

import java.util.List;

public enum Stage {
    CROSS_UP_STAIR(GameForm.UP_VALUE, GameForm.UP_VALUE, List.of(" ", GameForm.CORRECT_CODE)),
    CROSS_DOWN_STAIR(GameForm.DOWN_VALUE, GameForm.DOWN_VALUE, List.of(GameForm.CORRECT_CODE, " ")),
    CAN_NOT_CROSS_UP_STAIR(GameForm.DOWN_VALUE, GameForm.UP_VALUE, List.of(GameForm.WRONG_CODE, " ")),
    CON_NOT_CROSS_DOWN_STAIR(GameForm.UP_VALUE, GameForm.DOWN_VALUE, List.of(" ", GameForm.WRONG_CODE));

    private final String userMoving;
    private final String bridgeStage;
    private final List<String> mapElement;  //"아래 칸-위 칸"

    private Stage(String userMoving, String bridgeStage, List<String> mapElement) {
        this.userMoving = userMoving;
        this.bridgeStage = bridgeStage;
        this.mapElement = mapElement;
    }

    public static List<String> judge(String userMoving, String bridgeStage) {
        for (Stage stage : Stage.values()) {
            if (bridgeStage.equals(stage.bridgeStage) && userMoving.equals(stage.userMoving)) {
                return stage.mapElement;
            }
        }
        throw new IllegalArgumentException();
    }
}

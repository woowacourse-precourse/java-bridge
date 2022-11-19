package bridge.model;

import bridge.standard.GameForm;

import java.util.List;

public enum Stage {

    CROSS_UP_STAIR(GameForm.UP_CODE, GameForm.UP_CODE,
            List.of(GameForm.EMPTY_SPACE, GameForm.CORRECT_MARK)),
    CROSS_DOWN_STAIR(GameForm.DOWN_CODE, GameForm.DOWN_CODE,
            List.of(GameForm.CORRECT_MARK, GameForm.EMPTY_SPACE)),
    CAN_NOT_CROSS_UP_STAIR(GameForm.DOWN_CODE, GameForm.UP_CODE,
            List.of(GameForm.WRONG_MARK, GameForm.EMPTY_SPACE)),
    CON_NOT_CROSS_DOWN_STAIR(GameForm.UP_CODE, GameForm.DOWN_CODE,
            List.of(GameForm.EMPTY_SPACE, GameForm.WRONG_MARK));

    private final String userMoving;
    private final String bridgeStage;

    //D를 입력하면 인덱스 0(DOWN_LAYER)에, U을 입력하면 인덱스 1(UP_LAYER)에 O/X 마크 설정
    private final List<String> mapElement;

    private Stage(String userMoving, String bridgeStage, List<String> mapElement) {
        this.userMoving = userMoving;
        this.bridgeStage = bridgeStage;
        this.mapElement = mapElement;
    }

    public static List<String> judge(String userMoving, String bridgeStage) {
        for (Stage stage : Stage.values()) {
            if (userMoving.equals(stage.userMoving) && bridgeStage.equals(stage.bridgeStage)) {
                return stage.mapElement;
            }
        }
        throw new IllegalArgumentException();
    }

}

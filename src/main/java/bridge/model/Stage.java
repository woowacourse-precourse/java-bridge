package bridge.model;

public enum Stage {
    CROSS_UP_STAIR("U", "U", " -O"),
    CROSS_DOWN_STAIR("D", "D", "O- "),
    CAN_NOT_CROSS_UP_STAIR("D", "U", "X- "),
    CON_NOT_CROSS_DOWN_STAIR("U", "D", " -X");

    private final String userMoving;
    private final String bridgeStage;
    private final String mapElement;  //"아래 칸-위 칸"

    private Stage(String userMoving, String bridgeStage, String mapElement) {
        this.userMoving = userMoving;
        this.bridgeStage = bridgeStage;
        this.mapElement = mapElement;
    }

    public static String judge(String userMoving, String bridgeStage) {
        for (Stage stage : Stage.values()) {
            if (bridgeStage.equals(stage.bridgeStage) && userMoving.equals(stage.userMoving)) {
                return stage.mapElement;
            }
        }
        throw new IllegalArgumentException();
    }
}

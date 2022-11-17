package bridge.model;

public enum Stage {
    CROSS_UP_STAIR("U", "U", " -O"),
    CROSS_DOWN_STAIR("D", "D", "O- "),
    CAN_NOT_CROSS_UP_STAIR("U", "D", "X- "),
    CON_NOT_CROSS_DOWN_STAIR("D", "U", " -X");

    private final String bridgeStage;
    private final String userMoving;
    private final String mapElement;  //"아래 칸-위 칸"

    private Stage(String bridgeStage, String userMoving, String mapElement) {
        this.bridgeStage = bridgeStage;
        this.userMoving = userMoving;
        this.mapElement = mapElement;
    }

    public static String judge(String bridgeStage, String userMoving) {
        for (Stage stage : Stage.values()) {
            if (bridgeStage.equals(stage.bridgeStage) && userMoving.equals(stage.userMoving)) {
                return stage.mapElement;
            }
        }
        throw new IllegalArgumentException();
    }
}

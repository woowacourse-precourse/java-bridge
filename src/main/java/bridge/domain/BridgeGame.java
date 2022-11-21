package bridge.domain;

import java.util.List;

public class BridgeGame {
    private static final String CAN_MOVING = "O";
    private static final String CAN_NOT_MOVING = "X";

    private final Bridge bridge;
    private List<String> movements;
    private int movingCount;
    private int totalGame;
    private String lastMoving;

    public BridgeGame(Bridge bridge) {
        this.totalGame = 1;
        this.bridge = bridge;
    }

    public BridgeGame(List<String> movements, int totalGame, Bridge bridge) {
        this.movements = movements;
        this.movingCount = 0;
        this.totalGame = totalGame;
        this.bridge = bridge;
    }

    public boolean move(String crossDirection, String movingInput) {
        movements.add(movingInput); // 리스트에 이동 입력 정보 넣기
        addMovingCount();

        if (checkCanMoving(crossDirection, movingInput)) {
            setLastMoving(CAN_MOVING);
            return true;
        }
        setLastMoving(CAN_NOT_MOVING);
        return false;
    }

    private boolean checkCanMoving(String crossDirection, String movingInput) {
        return crossDirection.equals(movingInput);
    }

    public void retry() {
    }
}

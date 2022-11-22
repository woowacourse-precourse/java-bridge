package bridge.domain;

import java.util.List;

public class BridgeGame {
    private static final String CAN_MOVING = "O";
    private static final String CAN_NOT_MOVING = "X";
    private static final int INIT_FIRST_GAME = 1;
    private static final int INIT_MOVING_COUNT = 0;

    private final Bridge bridge;
    private List<String> movements;
    private int movingCount;
    private int totalGame;
    private String lastMoving;

    public BridgeGame(Bridge bridge) {
        this.totalGame = INIT_FIRST_GAME;
        this.bridge = bridge;
    }

    public BridgeGame(List<String> movements, int totalGame, Bridge bridge) {
        this.movements = movements;
        this.movingCount = INIT_MOVING_COUNT;
        this.totalGame = totalGame;
        this.bridge = bridge;
    }

    public boolean move(String crossDirection, String movingInput) {
        movements.add(movingInput);
        addMovingCount();

        if (checkCanMoving(crossDirection, movingInput)) {
            setLastMoving(CAN_MOVING);
            return true;
        }
        setLastMoving(CAN_NOT_MOVING);
        return false;
    }

    public void setMovingResult(String crossDirection, String movingInput) {
        if (checkCanMoving(crossDirection, movingInput)) {
            bridge.setMovingBridge(movingInput, CAN_MOVING);
            return;
        }
        bridge.setMovingBridge(movingInput, CAN_NOT_MOVING);
    }

    private boolean checkCanMoving(String crossDirection, String movingInput) {
        return crossDirection.equals(movingInput);
    }

    private void addMovingCount() {
        this.movingCount++;
    }

    public void retry() {
        bridge.initBridge();
        initMovingCount();
        addGameCount();
    }

    private void initMovingCount() {
        this.movingCount = INIT_MOVING_COUNT;
    }

    private void addGameCount() {
        this.totalGame++;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public int getTotalGame() {
        return totalGame;
    }

    public String getLastMoving() {
        return lastMoving;
    }

    private void setLastMoving(String movingResult) {
        lastMoving = movingResult;
    }
}

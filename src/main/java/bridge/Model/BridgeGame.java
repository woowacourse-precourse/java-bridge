package bridge.Model;

import bridge.MovingStatus;
import bridge.View.ExceptionMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int movementCount;
    private int round;
    private final Bridge bridge;
    private BridgeMap bridgeMap;
    private boolean isAnswer;

    public BridgeGame(Bridge bridge) {
        this.movementCount = 0;
        this.round = 1;
        this.bridge = bridge;
        this.bridgeMap = new BridgeMap();
    }

    public boolean validateMoving(String inputMoving) {
        try {
            validateIsRightMoving(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsRightMoving(String inputMoving) throws IllegalArgumentException {
        if (!inputMoving.equals("U") && !inputMoving.equals("D")) {
            throw new IllegalArgumentException(ExceptionMessage.MOVING_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }

    public void move(String movement) {
        isAnswer = bridge.checkAnswer(movement, movementCount);
        moveMap(movement);
        movementCount += 1;
    }

    void retry() {
        round += 1;
        movementCount = 0;
        this.bridgeMap = new BridgeMap();
    }

    void moveMap(String movement) {
        int moving = MovingStatus.findByCommand(movement).getMovingNumber();
        this.bridgeMap.updateMap(moving, isAnswer);
    }

    public boolean getIsAnswer() {
        return this.isAnswer;
    }

    public boolean isExit(String command) {
        if (command.equals("R")) {
            retry();
            return false;
        }
        return true;
    }

    public boolean checkSuccess() {
        boolean isEnd = (bridge.getBridgeSize() == movementCount);
        return (isEnd && isAnswer);
    }

    public int getRound() {
        return this.round;
    }

    public BridgeMap getBridgeMap() {
        return this.bridgeMap;
    }
}

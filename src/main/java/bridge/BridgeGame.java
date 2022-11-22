package bridge;

import static bridge.View.ExceptionMessage.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int movementCount;
    private int round;
    private boolean isAnswer;
    private BridgeMap bridgeMap;

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
        if (!inputMoving.equals("U") && !inputMoving.equals("D"))
            throw new IllegalArgumentException(MOVING_EXCEPTION_MESSAGE.getExceptionMessage());
    }

    public boolean validateGameCommand(String command) {
        try {
            validateIsRightCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsRightCommand(String command) throws IllegalArgumentException {
        if (!command.equals("R") && !command.equals("Q"))
            throw new IllegalArgumentException(GAME_COMMAND_EXCEPTION_MESSAGE.getExceptionMessage());
    }

    public void move(String movement) {
        isAnswer = bridge.checkAnswer(movement, movementCount);
        moveMap(movement);
        movementCount += 1;
    }

    void moveMap(String movement) {
        int moving = MovingStatus.findByCommand(movement).getMovingNumber();
        this.bridgeMap.updateMap(moving, isAnswer);
    }

    public boolean isExit(String command) {
        if (command.equals("R")) {
            retry();
            return false;
        }
        return true;
    }

    void retry() {
        round += 1;
        movementCount = 0;
        this.bridgeMap = new BridgeMap();
    }

    public boolean checkSuccess() {
        boolean isEnd = (bridge.getBridgeSize() == movementCount);
        return (isEnd && isAnswer);
    }

    public boolean getIsAnswer() {
        return this.isAnswer;
    }

    public int getRound() {
        return this.round;
    }

    public BridgeMap getBridgeMap() {
        return this.bridgeMap;
    }
}

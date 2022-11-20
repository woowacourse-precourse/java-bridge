package bridge;

import java.util.ArrayList;
import java.util.List;

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
        this.bridgeMap = new BridgeMap(new ArrayList<>());
        this.isAnswer = false;
    }

    void move(String movement) {
        checkAnswer(movement);
        markMove(movement);
        movementCount += 1;
    }

    void retry() {
        round += 1;
        movementCount = 0;
        bridgeMap = new BridgeMap(new ArrayList<>());
    }

    void markMove(String movement) {
        String mark = createMark();
        List<String> partition = new ArrayList<>(List.of(" ", " "));
        int moving = MovingStatus.findByCommand(movement).getMovingNumber();
        partition.set(moving, mark);
        bridgeMap.updateMap(partition);
    }

    String createMark() {
        if (isAnswer)
            return "O";
        return "X";
    }

    void checkAnswer(String movement) {
        this.isAnswer = bridge.getAnswerByCount(movementCount).equals(movement);
    }

    boolean getIsAnswer() {
        return this.isAnswer;
    }

    boolean isExit(String command) {
        if (command.equals("R")) {
            retry();
            return false;
        }
        return true;

    }

    boolean checkSuccess() {
        return (bridge.getBridgeSize() == movementCount && this.isAnswer);
    }

    int getRound() {
        return this.round;
    }

    BridgeMap getBridgeMap() {
        return this.bridgeMap;
    }
}

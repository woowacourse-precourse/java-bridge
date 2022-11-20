package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeOfComputer computerMap;
    private BridgeOfUser userMap;
    private int stage;
    private int tryCount;
    private boolean fail;
    private boolean done;

    public BridgeGame(List<String> answerBridgeMap) {
        this.computerMap = new BridgeOfComputer(answerBridgeMap);
        this.userMap = new BridgeOfUser();
        this.stage = 0;
        this.tryCount = 1;
        this.done = false;
        this.fail = false;
    }

    public void move(String moveSide) {
        boolean isRight = computerMap.match(stage, moveSide);
        if (isRight) {
            restoreRightMove(moveSide);
        }
        if (!isRight) {
            restoreWrongMove(moveSide);
        }
    }

    private void restoreRightMove(String moveSide) {
        userMap.restoreByRigth(moveSide);
        stage++;
        checkSuccess();
    }

    private void checkSuccess() {
        int computerMapLength = computerMap.getLength();
        if (userMap.equalsWithComputerMapLength(computerMapLength)) {
            done = true;
        }
    }

    private void restoreWrongMove(String moveSide) {
        userMap.restoreByWrong(moveSide);
        fail = true;
        done = true;
    }


    public BridgeOfUser nowUserMapState() {
        return userMap;
    }

    public void retry() {
        this.userMap = new BridgeOfUser();
        this.stage = 0;
        this.tryCount += 1;
        this.done = false;
        this.fail = false;
    }

    public boolean isDone() {
        return done;
    }

    public boolean isFail() {
        return fail;
    }
    public String calculateDoneResult() {
        if (fail) {
            return "실패";
        }
        return "성공";
    }

    public int getTryCount() {
        return tryCount;
    }
}

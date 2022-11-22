package bridge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, String> calculateDoneResults() {
        Map<String, String> results = new HashMap<>();
        calculateIsSuccess(results);
        calculateTryCount(results);
        return results;
    }

    private void calculateIsSuccess(Map<String, String> results) {
        if (fail) {
            results.put("성공여부", "실패");
        }
        if (!fail) {
            results.put("성공여부", "성공");
        }
    }

    private void calculateTryCount(Map<String, String> results) {
        results.put("시도횟수", String.valueOf(tryCount));
    }

    public boolean checkFinish() {
        return done;
    }

    public boolean isFail() {
        return fail;
    }
}

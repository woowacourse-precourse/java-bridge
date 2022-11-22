package bridge.service;

import bridge.model.MoveResult;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridgeList;
    private int moveCount;
    private int gameAttemptCount;
    private boolean progressStatus;

    public BridgeGame(List<String> bridgeList) {
        this.bridgeList = bridgeList;
        this.moveCount = 0;
        this.gameAttemptCount = 1;
        this.progressStatus = true;
    }

    public void move(String moving) {
        progressStatus = true;
        createBridgeResult(moving);
        moveCount++;
    }

    public void createBridgeResult(String moving) {
        boolean move = bridgeList.get(moveCount).equals(moving);
        MoveResult.apply(moving, move);
        if (!move)
            progressStatus = false;
    }

    public boolean isOver() {
        if (progressStatus && moveCount < bridgeList.size()) {
            return false;
        }
        return true;
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            initBeforeRestart();
        }
        return progressStatus;
    }

    public void initBeforeRestart() {
        progressStatus = true;
        moveCount = 0;
        gameAttemptCount++;
        MoveResult.retrySetting();
    }

    public boolean isSuccess() {
        return progressStatus && moveCount == bridgeList.size();
    }

    public String gameCount() {
        return "총 시도한 횟수: " + gameAttemptCount;
    }

    public String gameSuccess() {
        if (progressStatus) {
            return "성공";
        }
        return "실패";
    }
}

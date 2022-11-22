package bridge.domain.service;

import static bridge.domain.enums.Result.FAIL;
import static bridge.domain.enums.Result.SUCCESS;
import static bridge.domain.enums.Status.FAIL_STATUS;
import static bridge.domain.enums.Status.PROGRESS_STATUS;
import static bridge.domain.enums.Status.SUCCESS_STATUS;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.request.BridgeSizeRequest;
import bridge.controller.request.MoveRequest;
import bridge.domain.enums.Result;
import bridge.domain.model.Bridge;
import bridge.domain.model.GameResult;
import bridge.domain.model.ScoreMap;
import bridge.domain.enums.Move;
import bridge.domain.enums.Status;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final ScoreMap scoreMap;

    private boolean isGameOver;
    private int step;
    private int tryCount;
    private Status status;

    public BridgeGame(BridgeSizeRequest request) {
        this.bridge = createBridge(request.getSize());
        this.scoreMap = new ScoreMap();
        this.isGameOver = false;
        this.tryCount = 1;
        this.step = 0;
        this.status = PROGRESS_STATUS;
    }

    private Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public ScoreMap move(MoveRequest moveRequest) {
        Move direction = moveRequest.getMove();
        scoreMap.score(judge(direction), direction);
        if (isSuccess()) {
            isGameOver = true;
            status = SUCCESS_STATUS;
        }
        return scoreMap;
    }

    private Result judge(Move direction) {
        if (bridge.isCorrectWay(direction, step)) {
            step++;
            return SUCCESS;
        }
        isGameOver = true;
        status = FAIL_STATUS;
        return FAIL;
    }

    public void retry() {
        scoreMap.clear();
        step = 0;
        tryCount++;
        isGameOver = false;
        status = PROGRESS_STATUS;
    }

    private boolean isSuccess() {
        return step == bridge.size();
    }

    public Status getStatus() {
        return status;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public GameResult getResultOfGame() {
        return new GameResult(scoreMap, status, tryCount);
    }
}

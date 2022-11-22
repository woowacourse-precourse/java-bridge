package bridge.domain.service;

import static bridge.domain.enums.Status.PROGRESS_STATUS;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.request.BridgeSizeRequest;
import bridge.controller.request.MoveRequest;
import bridge.domain.model.Bridge;
import bridge.domain.model.ScoreMap;
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
        return null;
    }

    public void retry() {

    }

    private boolean isSuccess() {
        return step == bridge.size();
    }


}

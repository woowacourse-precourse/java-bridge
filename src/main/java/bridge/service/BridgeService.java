package bridge.service;

import bridge.BridgeMaker;
import bridge.dto.TryCountDto;
import bridge.vo.Bridge;
import bridge.vo.StepResult;
import bridge.vo.enums.Step;

public class BridgeService {
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeService(BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeBridge(int bridgeSize) {
        return new Bridge(Step.from(bridgeMaker.makeBridge(bridgeSize)));
    }

    public StepResult move(Step userStep, Step answerStep) {
        return bridgeGame.move(userStep, answerStep);
    }

    public void retry(TryCountDto tryCount) {
        bridgeGame.retry(tryCount);
    }
}

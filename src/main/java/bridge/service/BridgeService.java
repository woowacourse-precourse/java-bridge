package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ViewStatus;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.dto.GameResult;

public class BridgeService {

    private BridgeGame bridgeGame;

    public ViewStatus makeBridge(Integer size) {
        BridgeMaker bridgeMaker =
                new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(size));
        bridgeGame = BridgeGame.from(bridge);

        return ViewStatus.DETERMINE_MOVE;
    }

    public GameResult move(String moveCommand) {
        //move
        boolean isMatch = bridgeGame.move(moveCommand);
        //result
        return bridgeGame.resultOfMove(isMatch);
    }
}

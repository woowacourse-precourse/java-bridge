package bridge.model.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Constant;
import bridge.enums.Bridge;
import bridge.model.domain.BridgeGame;
import bridge.model.dto.MoveResultDto;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void createBridge(int bridgeSize) {
        List<String> bridgesSign = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridgesSign);
    }

    public MoveResultDto move(String bridgeType) {
        Bridge bridgeToMove = Bridge.findBySign(bridgeType);

        return bridgeGame.move(bridgeToMove);
    }

    public boolean retry(String gameCommand) {
        boolean isRestartGame = gameCommand.equals(Constant.RESTART_GAME);
        bridgeGame.retry(isRestartGame);
        return isRestartGame;
    }
}

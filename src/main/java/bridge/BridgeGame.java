package bridge;

import static bridge.configuration.AppConfig.bridgeMaker;
import static bridge.domain.bridge.Bridge.convert;
import static bridge.domain.bridge.BridgeAndPasser.compress;
import static bridge.domain.bridge.BridgePasser.makeBridgePasser;
import static bridge.domain.game.GameResult.makeGameResult;

import bridge.domain.game.GameRecord;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeAndPasser;
import bridge.domain.bridge.BridgePasser;
import bridge.domain.game.GameResult;
import bridge.value.BridgeCharacter;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgePasser bridgePasser;
    private final Bridge bridge;
    private final GameRecord gameRecord;

    public BridgeGame(BridgePasser bridgePasser, Bridge bridge, GameRecord gameRecord) {
        this.bridgePasser = bridgePasser;
        this.bridge = bridge;
        this.gameRecord = gameRecord;
    }

    public static BridgeGame createGame(int bridgeSize) {
        Bridge bridge = convert(bridgeMaker().makeBridge(bridgeSize));
        BridgePasser bridgePasser = makeBridgePasser(bridge);

        return new BridgeGame(bridgePasser, bridge, new GameRecord());
    }

    public boolean canMove(BridgeCharacter bridgeCharacter) {
        return bridgePasser.canMove(bridgeCharacter);
    }

    public void move() {
        if(isGameSuccess()) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }

        bridgePasser.move();
    }

    public boolean isGameSuccess() {
        return bridgePasser.isBridgeEnd();
    }

    public void retry() {
        bridgePasser.clear();
        gameRecord.addRetryCount();
    }

    public BridgeAndPasser bridgeAndPasser() {
        return compress(bridge, bridgePasser);
    }

    public GameResult gameResult() {
        return makeGameResult(bridge, bridgePasser, gameRecord);
    }
}

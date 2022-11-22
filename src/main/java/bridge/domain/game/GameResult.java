package bridge.domain.game;

import static bridge.domain.bridge.BridgeAndPasser.compress;
import static bridge.value.GameSuccessStatus.calcGameStatus;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeAndPasser;
import bridge.domain.bridge.BridgePasser;
import bridge.value.GameSuccessStatus;

public class GameResult {

    private final BridgeAndPasser bridgeAndPasser;
    private final GameSuccessStatus gameSuccessStatus;
    private final GameRecord gameRecord;

    public BridgeAndPasser getBridgeAndPasser() {
        return bridgeAndPasser;
    }

    public GameSuccessStatus getGameSuccessStatus() {
        return gameSuccessStatus;
    }

    public GameRecord getGameRecord() {
        return gameRecord;
    }

    public GameResult(BridgeAndPasser bridgeAndPasser, GameSuccessStatus gameSuccessStatus, GameRecord gameRecord) {
        this.bridgeAndPasser = bridgeAndPasser;
        this.gameSuccessStatus = gameSuccessStatus;
        this.gameRecord = gameRecord;
    }

    public static GameResult makeGameResult(Bridge bridge, BridgePasser bridgePasser, GameRecord gameRecord) {
        return new GameResult(compress(bridge, bridgePasser), calcGameStatus(bridgePasser.isBridgeEnd()), gameRecord);
    }

}

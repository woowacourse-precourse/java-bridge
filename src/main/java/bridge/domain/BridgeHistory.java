package bridge.domain;

import java.util.List;

public class BridgeHistory {

    private final BridgePlayer playerBridgeHistory;
    private final BridgeAnswer bridgeAnswer;

    public BridgeHistory(BridgePlayer playerBridgeHistory, BridgeAnswer bridgeAnswer) {
        this.playerBridgeHistory = playerBridgeHistory;
        this.bridgeAnswer = bridgeAnswer;
    }

    public List<BridgeMoveType> getPlayerBridge() {
        return playerBridgeHistory.getMoveHistory();
    }

    public List<BridgeMoveType> getBridgeAnswer() {
        return bridgeAnswer.getAnswerMoveHistory();
    }

}

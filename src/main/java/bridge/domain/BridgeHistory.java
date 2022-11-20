package bridge.domain;

import java.util.List;

public class BridgeHistory {

    private final BridgePlayer playerBridgeHistory;
    private final BridgeAnswer bridgeAnswer;
    private final BridgeGameRound bridgeGameRound;

    public BridgeHistory(BridgePlayer playerBridgeHistory, BridgeAnswer bridgeAnswer, BridgeGameRound bridgeGameRound) {
        this.playerBridgeHistory = playerBridgeHistory;
        this.bridgeAnswer = bridgeAnswer;
        this.bridgeGameRound = bridgeGameRound;
    }

    public List<BridgeMoveType> getPlayerBridge() {
        return playerBridgeHistory.getMoveHistory();
    }

    public List<BridgeMoveType> getBridgeAnswer() {
        return bridgeAnswer.getAnswerMoveHistory();
    }

    public int getBridgeGameRound() {
        return bridgeGameRound.checkRound();
    }

    public BridgeGameState getGameResult() {
        return bridgeAnswer.compareWith(playerBridgeHistory);
    }
}

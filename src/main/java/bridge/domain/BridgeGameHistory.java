package bridge.domain;

import java.util.List;

public class BridgeGameHistory {

    private final BridgePlayer playerBridgeHistory;
    private final BridgeAnswer bridgeAnswer;
    private final BridgeGameRound bridgeGameRound;

    private BridgeGameHistory(BridgePlayer playerBridgeHistory,
                              BridgeAnswer bridgeAnswer,
                              BridgeGameRound bridgeGameRound
    ) {
        this.playerBridgeHistory = playerBridgeHistory;
        this.bridgeAnswer = bridgeAnswer;
        this.bridgeGameRound = bridgeGameRound;
    }

    public static BridgeGameHistory of(BridgePlayer playerBridgeHistory,
                                       BridgeAnswer bridgeAnswer,
                                       BridgeGameRound bridgeGameRound
    ) {
        return new BridgeGameHistory(playerBridgeHistory, bridgeAnswer, bridgeGameRound);
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

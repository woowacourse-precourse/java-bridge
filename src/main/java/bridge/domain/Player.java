package bridge.domain;

public class Player {

    private final GamePlayCount gamePlayCount;
    private final BridgeGameResult bridgeGameResult;
    private final Round round;

    public Player(GamePlayCount gamePlayCount, Round round, BridgeGameResult bridgeGameResult) {
        this.gamePlayCount = gamePlayCount;
        this.round = round;
        this.bridgeGameResult = bridgeGameResult;
    }
}

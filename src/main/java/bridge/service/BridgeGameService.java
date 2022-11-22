package bridge.service;

import bridge.constant.command.Command;
import bridge.domain.BridgeGame;

public class BridgeGameService {

    private final BridgeGame bridgeGame;
    private int tryCnt = 1;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void moveNext(String command) {
        bridgeGame.move(command);
    }

    public boolean success() {
        if ( !bridgeGame)
    }
}

package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.validator.BridgeGameEnd;
import bridge.service.validator.BridgeLength;
import bridge.service.validator.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {

    private Bridge bridge;
    private boolean isEndGame = false;

    private GameRound gameRound;
    private int tryCount = 0;

    public BridgeGame() {
        setBridge(setBridgeLength());
    }

    private int setBridgeLength() {
        BridgeLength bridgeLength = new BridgeLength();
        return bridgeLength.inputBridgeSize();
    }

    private void setBridge(int bridgeLength) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));
    }

    public void playGame() {
        this.gameRound = new GameRound(this.bridge);
        this.tryCount++;

        while (true) {
            if (!this.gameRound.isContinueRound()) {
                this.isEndGame = true;
                break;
            }

            if (!move(this.gameRound.winRound()))
                break;
        }
    }

    private boolean move(boolean isWin) {
        if (!isWin)
            return false;

        return true;
    }

    public boolean retry() {
        if (this.isEndGame)
            return false;

        BridgeGameEnd bridgeGameEnd = new BridgeGameEnd();
        if (bridgeGameEnd.isEnd())
            return false;

        return true;
    }

    public void end() {
        gameRound.end(this.isEndGame, this.tryCount);
    }
}

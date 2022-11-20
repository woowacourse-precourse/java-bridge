package bridge.service;

import bridge.command.MarkCommand;
import bridge.domain.BridgeGame;

import java.util.List;

public class BridgeGameService {
    private final BridgeGame bridgeGame;
    private int numberOfAttempts = 1;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void startOneRound(String command) {
        bridgeGame.move(command);
    }

    public void restart() {
        numberOfAttempts++;
        bridgeGame.retry();
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public boolean success() {
        if (!bridgeGame.getResult().contains(MarkCommand.Impossible.get())) return true;
        return false;
    }

    public boolean isComplete() {
        if ((bridgeGame.getBridgeSize() == bridgeGame.getResultSize()) && success()) return true;
        return false;
    }

    public List<String> getResult() {
        return bridgeGame.getResult();
    }

    public List<String> getBridge() {
        return bridgeGame.getBridge();
    }
}

package bridge.service;

import bridge.constant.command.Command;
import bridge.constant.message.GameMessage;
import bridge.domain.BridgeGame;

import java.util.List;

public class BridgeGameService {

    private final BridgeGame bridgeGame;
    private int tryCnt = 1;

    public BridgeGameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void moveNext(String command) {
        bridgeGame.move(command);
    }

    public boolean isComplete() {
        if (success() && (bridgeGame.getBridgeSize() == bridgeGame.getSelectionsSize())) return true;
        return false;
    }

    public boolean success() {
        if (!bridgeGame.getSelections().contains(Command.IMPOSSIBLE.getCommand())) return true;
        return false;
    }

    public List<String> getSelections() {
        return bridgeGame.getSelections();
    }

    public List<String> getBridge() {
        return bridgeGame.getBridge();
    }

    public void restart() {
        tryCnt++;
        bridgeGame.retry();
    }

    public String gameStatus() {
        if (!isComplete()) return GameMessage.GAME_RESULT_FAIL.getMessage();
        return GameMessage.GAME_RESULT_SUCCESS.getMessage();
    }

    public int getTryCnt() {
        return tryCnt;
    }
}

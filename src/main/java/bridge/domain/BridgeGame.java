package bridge.domain;

import java.util.List;

import static bridge.util.Constant.*;

public class BridgeGame {
    private List<String> bridgeGame;
    private int tryCount;

    public BridgeGame(List<String> bridgeGame, int tryCount) {
        this.bridgeGame = bridgeGame;
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        tryCount ++;
    }

    public boolean move(String moveSide, int index) {
        return bridgeGame.get(index).equals(moveSide);
    }

    public boolean retry(String command) {
        if (command.equals("R")) return true;
        if (command.equals("Q")) return false;
        throw new IllegalArgumentException(RETRY_COMMAND_INPUT);
    }
}

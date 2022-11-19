package bridge;

import bridge.constant.GameStatus;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameStat {

    private List<BridgeMap> bridgeMaps;

    private GameStatus gameStatus;

    private int countOfGame;

    public BridgeGameStat() {
        this.bridgeMaps = new ArrayList<>();
        this.gameStatus = GameStatus.FAIL;
        this.countOfGame = 1;
    }

    public List<BridgeMap> getBridgeMaps() {
        return bridgeMaps;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getCountOfGame() {
        return countOfGame;
    }

    public void restart() {
        this.bridgeMaps = new ArrayList<>();
        this.gameStatus = GameStatus.FAIL;
        this.countOfGame++;
    }

    public void gameWin() {
        this.gameStatus = GameStatus.SUCCESS;
    }
}

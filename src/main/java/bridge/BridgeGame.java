package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    GameConstructor gameConstructor;
    int tryCount;
    boolean wrongMovement = true;
    boolean playMore = true;
    List<String> bridge;

    public BridgeGame(GameConstructor gameConstructor) {
        this.gameConstructor = gameConstructor;
        this.bridge = gameConstructor.bridge;
    }

    public boolean move() {
        return gameConstructor.getMoveBool();
    }

    public void playOneGame() {
        tryCount = 0;
        while (playMore && wrongMovement) {
            gameConstructor.clearResult();
            wrongMovement = move();
            retry();
            tryCount += 1;
        }
    }

    public boolean retry() {
        playMore = true;
        if (wrongMovement) {
            playMore = gameConstructor.askForRetry();
        }
        return  playMore;
    }

    public void play () {
            playOneGame();
            gameConstructor.resultPrint(tryCount);
        }
    }
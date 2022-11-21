package bridge;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public ArrayList<String> bridge = new ArrayList<>();
    public ArrayList<String> currentCoordinate = new ArrayList<>();
    public int bridgeCount = 0;
    public int gameCount = 1;
    public boolean gameOver = false;
    public boolean completeBridge = false;
    public boolean retry = true;
    OutputView bridgeShape = new OutputView();
    public void makeBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public void move(String moving) {
        this.currentCoordinate.add(moving);
        bridgeCheck();
    }

    public void bridgeCheck() {
        if (isCompleteBridge())
            return;
        if (isGameOver())
            return;
        bridgeShape.printMap(bridgeCount, currentCoordinate);
        bridgeCount += 1;
    }

    private boolean isGameOver() {
        if (!Objects.equals(this.bridge.get(bridgeCount), this.currentCoordinate.get(bridgeCount))) {
           bridgeShape.printFailedMap(currentCoordinate,bridgeCount);
           this.gameOver = true;
            return true;
       }
        return false;
    }

    private boolean isCompleteBridge() {
        if (Objects.equals(this.bridge,this.currentCoordinate)){
           bridgeShape.printResultMap(currentCoordinate,gameCount);
           bridgeShape.printFinalResult(currentCoordinate,gameCount);
           this.completeBridge = true;
            return true;
        }
        return false;
    }

    public void retry(String restart) {
        String quitGame = "Q";
        String retryGame = "R";
        isQuitGame(restart, quitGame);
        isRetryGame(restart, retryGame);
    }

    private void isQuitGame(String restart, String quitGame) {
        if (Objects.equals(restart, quitGame)){
            this.retry = false;
            bridgeShape.printFinalFailed(currentCoordinate,gameCount);
        }
    }

    private void isRetryGame(String restart, String retryGame) {
        if (Objects.equals(restart, retryGame)){
            this.gameCount += 1;
            int lastChar = currentCoordinate.size()-1;
            this.currentCoordinate.remove(lastChar);
        }
    }
}

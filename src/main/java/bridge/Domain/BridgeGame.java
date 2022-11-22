package bridge.Domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Database.BridgeData;
import java.util.Objects;

import static bridge.Constants.StandardTools.GameStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final BridgeData bridgeData = new BridgeData();
    public final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private GameStatus gameStatus;

    public void move(String nextStep) {
        gameStatus = GameStatus.PROGRESSING;
        bridgeData.addBridgeDesignByUser(nextStep);
        validateNextStep(nextStep, bridgeData.returnBridgeByUserSize() - 1);
    }

    private void validateNextStep(String nextStep, int indexOfBridgeEnd) {
        if (bridgeData.isBridgeAtIndexImpossibleZone(indexOfBridgeEnd, nextStep)) {
            gameStatus = GameStatus.FAILED;
            bridgeData.markFailedPointOnBridgeDesignByUser(indexOfBridgeEnd);
        }
        validateGameSuccessfullyFinished();
    }

    public void validateGameSuccessfullyFinished() {
        if (bridgeData.isBridgeDesignByUserCompleted()) {
            gameStatus = GameStatus.SUCCEED;
        }
    }

    public void retry(String gameCommand) {
        if (Objects.equals(gameCommand, "R")) {
            initializeBridgeDesignByUser();
            bridgeData.increaseAttempts();
            gameStatus = GameStatus.RETRY;
        }
        if (Objects.equals(gameCommand, "Q")) {
            gameStatus = GameStatus.QUIT;
        }
    }

    public void initializeBridgeDesignByUser() {
        bridgeData.initializeBridgeDesignByUser();
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public boolean isGameContinue() {
        return this.gameStatus == GameStatus.PROGRESSING || this.gameStatus == GameStatus.RETRY;
    }

    public BridgeGame(int bridgeLength) {
        gameStatus = GameStatus.PROGRESSING;
        bridgeData.setBridge(bridgeMaker.makeBridge(bridgeLength));
        System.out.println(bridgeData.copyBridge());
        bridgeData.initializeTotalAttempt();
    }
}

package bridge.Domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constants.FrontMan;
import bridge.Database.BridgeData;
import bridge.UI.InputView;
import java.util.Objects;

import static bridge.Constants.StandardTools.GameStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final BridgeData bridgeData = new BridgeData();
    public final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public final InputView inputView = new InputView();
    private GameStatus gameStatus;

    public BridgeGame() {
        System.out.println(FrontMan.BRIDGE_GAME_IS_BEGINNING + "\n");
        gameStatus = GameStatus.PROGRESSING;
        bridgeData.setBridge(bridgeMaker.makeBridge(inputView.readBridgeLength()));
        System.out.println(bridgeData.getBridge());
        bridgeData.initializeTotalAttempt();
    }

    public void move() {
        gameStatus = GameStatus.PROGRESSING;
        String nextStep = inputView.readMoving();
        bridgeData.addBridgeDesignByUser(nextStep);
        validateNextStep(nextStep, bridgeData.getBridgeDesignByUser().size() - 1);
    }

    private void validateNextStep(String nextStep, int indexOfBridgeEnd) {
        if (!Objects.equals(bridgeData.getBridge().get(indexOfBridgeEnd), nextStep)) {
            gameStatus = GameStatus.FAILED;
            bridgeData.markFailedPointOnBridgeDesignByUser(indexOfBridgeEnd);
            retry();
        }
        validateGameSuccessfullyFinished();
    }

    public void validateGameSuccessfullyFinished() {
        if (Objects.equals(bridgeData.getBridge(), bridgeData.getBridgeDesignByUser())) {
            gameStatus = GameStatus.SUCCEED;
        }
    }

    public void retry() {
        String gameCommand = inputView.readGameCommand();
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
}

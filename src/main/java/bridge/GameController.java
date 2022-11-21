package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Validation.*;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public GameController(OutputView outputView, InputView inputView, BridgeMaker bridgeMaker) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }
    public void manageGame(BridgeGame bridgeGame, Bridge bridge) {
        int tryCount = 1;
        while(true) {
            startGame(bridgeGame, bridge);
            if (!restartGame(bridgeGame, bridge)) {
                endGame(bridgeGame, bridge, tryCount);
                break;
            }
            tryCount++;
        }
    }

    public int createBridgeSize() {
        try {
            int bridgeSize = isPositiveInteger(inputView.readBridgeSize());
            isInRange(bridgeSize);
            return bridgeSize;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createBridgeSize();
        }
    }
    public void readyForGame() {
        outputView.printStartGame();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(createBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame();
        manageGame(bridgeGame, bridge);
    }

    public void activateUserTurn(BridgeGame bridgeGame, Bridge bridge) {
        while(true) {  // 검증 로직 추가해야함
            String userSelect = inputView.readMoving();
            bridgeGame.move(userSelect);
            outputView.printMap(bridge.getBridge(), bridgeGame.getUserPath());
            int bridgePosition = bridgeGame.getBridgePosition();
            if(!bridge.moveCheck(userSelect, bridgePosition) || bridgeGame.checkGameClear(bridge)) {
                break;
            }
        }
    }

    public void startGame(BridgeGame bridgeGame, Bridge bridge) {
        try {
            activateUserTurn(bridgeGame, bridge);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            startGame(bridgeGame, bridge);
        }
    }

    public boolean restartGame(BridgeGame bridgeGame, Bridge bridge) {
        if (bridgeGame.checkGameClear(bridge)) {
            return false;
        }
        return checkRestart(bridgeGame);
    }
    public boolean checkRestart(BridgeGame bridgeGame) {
        try {
            return getRestartCommand(bridgeGame);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return checkRestart(bridgeGame);
        }
    }

    public boolean getRestartCommand(BridgeGame bridgeGame) {
        String command = inputView.readGameCommand();
        Validation.validateContinue(command);
        if (command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public void endGame(BridgeGame bridgeGame, Bridge bridge, int tryCount) {
        outputView.printMapResult(bridge.getBridge(), bridgeGame.getUserPath());
        outputView.printGameResult(bridgeGame.checkGameClear(bridge));
        outputView.printTotalTry(tryCount);
    }

}
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
        while(true) { // 게임 성공 여부
            if (startGame(bridgeGame, bridge) || !checkRestart(bridgeGame)) {
                break;
            }
            tryCount++;
        }
        endGame(success, tryCount);
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

    public boolean activateUserTurn(BridgeGame bridgeGame, Bridge bridge) {
        while(true) {  // 검증 로직 추가해야함
            String userSelect = inputView.readMoving();
            bridgeGame.move(userSelect);
            outputView.printMap(bridge.getBridge(), bridgeGame.getUserPath());
            int bridgePosition = bridgeGame.getBridgePosition();
            if(!bridge.moveCheck(userSelect, bridgePosition)) {
                return false;// 실패
            }
            if(bridge.checkClear(bridge.moveCheck(userSelect, bridgePosition), bridgePosition)) {
                return true; // 성공
            }
        }
    }

    public boolean startGame(BridgeGame bridgeGame, Bridge bridge) {
        try {
            return activateUserTurn(bridgeGame, bridge);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return startGame(bridgeGame, bridge);
        }
    }

    public boolean checkRestart(BridgeGame bridgeGame) {
        try {
            return restartGame(bridgeGame);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return checkRestart(bridgeGame);
        }
    }

    public boolean restartGame(BridgeGame bridgeGame) {
        String command = inputView.readGameCommand();
        Validation.validateMoveTo(command);
        if (command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public void endGame(boolean success, int tryCount) {
        outputView.printGameResult(success);
        outputView.printTotalTry(tryCount);
    }

}
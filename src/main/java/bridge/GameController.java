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
            boolean canMove = startGame(bridgeGame, userPath);
            boolean isClear = bridgeGame.checkClear(canMove, userPath.getBridgePosition());
            if (isClear) {
                break; // 클리어 or 재시작:Q -> 게임종료
            }
            if (!canMove) {
                reStartGame(userPath, bridgeGame);
                tryCount++;
            }
        }
        endGame(isClear, tryCount);
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
        while(true) {
            String userSelect = inputView.readMoving();
            bridgeGame.move(userSelect);
            boolean canMove = bridge.moveCheck(userSelect, bridgeGame.getBridgePosition());  // 건널 다리의 위치는 userPath의 길이와 동일하다
            outputView.printMap(bridge.getBridge(), bridgeGame.getUserPath());
            if(!canMove) {
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

    public boolean reStartGame(UserPath userPath, BridgeGame bridgeGame) {
        try {
            if (inputView.readGameCommand().equals("R")) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            reStartGame(userPath, bridgeGame);
        }
        return false;
    }

    public void endGame(boolean success, int tryCount) {
        outputView.printGameResult(success);
        outputView.printTotalTry(tryCount);
    }

}
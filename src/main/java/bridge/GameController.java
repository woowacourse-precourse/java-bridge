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
    public void manageGame(BridgeGame bridgeGame, UserPath userPath) {
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
        List<String> bridge = bridgeMaker.makeBridge(createBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        UserPath userPath = new UserPath();
        manageGame(bridgeGame, userPath);
    }

    public boolean activateUserTurn(BridgeGame bridgeGame, UserPath userPath) {
        while(true) {
            String userSelect = inputView.readMoving();
            userPath.addPath(userSelect);
            boolean canMove = bridgeGame.move(userSelect, userPath.getBridgePosition()); // 건널 다리의 위치는 userPath의 길이와 동일하다
            outputView.printMap(bridgeGame.getBridge(), userPath.getUserPath());
            if(!canMove) {
                break;
            }
        }
    }

    public void startGame(BridgeGame bridgeGame, UserPath userPath) {

        try {
            return activateUserTurn(bridgeGame, userPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return activateUserTurn(bridgeGame, userPath);
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
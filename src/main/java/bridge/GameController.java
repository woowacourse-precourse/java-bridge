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
        boolean clear = false;
        while(true) {
            int tryCount = 1;
            boolean canMove = startGame(bridgeGame, userPath;
            if (bridgeGame.checkArriveDestination(canMove, bridgePosition)) {
                outputView.printMapResult(bridge, userPath);
                clear = true;
                break; // 클리어 -> 게임종료
            }
            bridgePosition += 1;
            if(canMove) {
                continue;
            }
            // 틀렸으므로 재시작 여부 확인
            String reGame = inputView.readGameCommand();
            if (!canMove && reGame.equals("Q")) { // 재시작x
                break;
            }
            if (!canMove && reGame.equals("R")) { // 재시작 o
                userPath = bridgeGame.retry(userPath);
                bridgePosition = 0;
                tryCount += 1;
            }
        }
        // 게임종료 절차
        outputView.printGameResult(clear);
        outputView.printTotalTry(tryCount);
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
        String userSelect = inputView.readMoving();
        userPath.addPath(userSelect);
        // 건널 다리의 위치는 userPath의 길이와 동일하다
        boolean canMove = bridgeGame.move(userSelect, userPath.getBridgePosition());
        outputView.printMap(bridgeGame.getBridge(), userPath.getUserPath());
        return canMove;
    }

    public boolean startGame(BridgeGame bridgeGame, UserPath userPath) {
        try {
            return activateUserTurn(bridgeGame, userPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return activateUserTurn(bridgeGame, userPath);
        }

    }

}
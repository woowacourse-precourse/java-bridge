package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Validation.*;

public class GameController {
    public GameController() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printStartGame();
        int bridgeSize = createBridgeSize(inputView);
        Validation.isInRange(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        List<String> userPath = new ArrayList<String>();
        boolean clear;
        int tryCount = 1;
        while(true) {
            String userSelect = inputView.readMoving();
            userPath.add(userSelect);
            boolean canMove = bridgeGame.move(userSelect);
            if (bridgeGame.checkArriveDestination(canMove)) {
                outputView.printMapResult(bridge, userPath);
                clear = true;
                break; // 클리어 -> 게임종료
            }
            // 틀렸으므로 재시작 여부 확인
            if (!canMove && inputView.readGameCommand().equals("Q")) { // 재시작x
                clear = false;
                break;
            }
            if (!canMove && inputView.readGameCommand().equals("R")) { // 재시작 o
                userPath = bridgeGame.retry(userPath);
                tryCount += 1;
                continue;
            }
            outputView.printMap(bridge, userPath);
        }
        // 게임종료 절차
        outputView.printGameResult(clear);
        outputView.printTotalTry(tryCount);
    }

    public int createBridgeSize(InputView inputView) {
        try {
            return Validation.isPositiveInteger(inputView.readBridgeSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createBridgeSize(inputView);
        }
    }
}
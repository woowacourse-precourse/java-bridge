package bridge.gameController;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    private List<String> builtBridge;

    private int location;
    private int cnt;

    public void run() {
        makeBridge();
        boolean flag = true;
        while (flag) {
            cnt++;
            if (moveBridge()) {
                return;
            }
            flag = retryCheck();
        }
        outputView.printResult(false,cnt);
    }

    private void makeBridge() {
        outputView.startMessage();
        builtBridge = bridgeGame.makeBridge(inputView.readBridgeSize());
    }

    private boolean moveBridge() {
        boolean moveCheck = true;
        while (moveCheck) {
            moveCheck =isMoveCheck(moveCheck);
            if (builtBridge.size() - 1 == location && moveCheck == true) {
                outputView.printResult(true, cnt);
                return true;
            }
            ++location;
        }
        return false;
    }

    private String moveChoice() {
        outputView.choiceUpDown();
        String userMove = inputView.readMoving();
        System.out.println(userMove);
        return userMove;
    }

    private boolean retryCheck() {

        outputView.restartMessage();
        String command = inputView.readGameCommand();
        boolean checkCommand = bridgeGame.retry(command);
        if (checkCommand == true) {
            outputView = new OutputView();
            location = 0;
            return true;
        }
        return false;
    }

    private boolean isMoveCheck(boolean moveCheck){
        String userMove = moveChoice();
        moveCheck = bridgeGame.move(userMove, location, builtBridge);
        outputView.printMap(moveCheck, userMove, location);
        return moveCheck;
    }
}


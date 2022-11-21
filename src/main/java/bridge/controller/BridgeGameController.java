package bridge.controller;

import bridge.presentation.OutputView;
import bridge.service.BridgeGame;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    public void excute() {
        int challengeCount = 1;
        OutputView outputView = new OutputView();
        List<String> userSelectResult = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.startSetUp();
        List<String> computerResult = bridgeGame.make();
        while (true) {
            userSelectResult = bridgeGame.move(userSelectResult);
            boolean unitSuccess = bridgeGame.isUnitSuccess(userSelectResult, computerResult);
            boolean gameSuccess = bridgeGame.isGameSuccess(userSelectResult, computerResult, unitSuccess);
            if (!unitSuccess) {
                boolean restart = bridgeGame.retry(unitSuccess, gameSuccess);
                if (restart) {
                    challengeCount++;
                    userSelectResult.clear();
                    continue;
                }//if
                outputView.printResult(userSelectResult, unitSuccess, gameSuccess, challengeCount);
                break;
            }//if
            if (gameSuccess) {
                outputView.printResult(userSelectResult, unitSuccess, gameSuccess, challengeCount);
                break;
            }//if
        }//while
    }// excute
}// end class

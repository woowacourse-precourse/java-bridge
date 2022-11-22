package bridge.controller;

import bridge.presentation.OutputView;
import bridge.service.BridgeGame;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    BridgeGame bridgeGame = new BridgeGame();
    int challengeCount = 1;

    public void execute() {
        List<String> userSelectResult = new ArrayList<>();
        bridgeGame.startSetUp();
        List<String> computerResult = bridgeGame.make();
        loopGameUnit(userSelectResult, computerResult);
    }// execute

    private void loopGameUnit(List<String> userSelectResult, List<String> computerResult) {
        boolean loopController = true;
        while (loopController) {
            userSelectResult = bridgeGame.move(userSelectResult);
            boolean unitSuccess = bridgeGame.isUnitSuccess(userSelectResult, computerResult);
            boolean gameSuccess = bridgeGame.isGameSuccess(userSelectResult, computerResult, unitSuccess);
            boolean willRestart = isUnitFail(unitSuccess, gameSuccess);
            userSelectResult = restart(willRestart, userSelectResult);
            loopController = isLoopFinish(userSelectResult, unitSuccess, gameSuccess, challengeCount, willRestart);
        }//while
    }//loopGameUnit

    private boolean isUnitFail(boolean unitSuccess, boolean gameSuccess) {
        if (!unitSuccess) {
            return bridgeGame.retry(unitSuccess, gameSuccess);
        }//if
        return false;
    }//isUnitFail

    private List<String> restart(boolean willRestart, List<String> userSelectResult) {
        if (willRestart) {
            challengeCount++;
            userSelectResult.clear();
        }//if
        return userSelectResult;
    }//restart

    private boolean isLoopFinish(
            List<String> userSelectResult, boolean unitSuccess, boolean gameSuccess, int challengeCount, boolean willRestart) {
        OutputView outputView = new OutputView();
        boolean loopController = true;
        if ((!willRestart && !unitSuccess) || gameSuccess) {
            outputView.printResult(userSelectResult, unitSuccess, gameSuccess, challengeCount);
            loopController = false;
        }//if
        return loopController;
    }// isLoopFinish
}// end class

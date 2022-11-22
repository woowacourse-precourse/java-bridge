package bridge.controller;

import bridge.*;
import bridge.model.BridgeGame;
import bridge.model.LowerBridge;
import bridge.model.UpperBridge;
import bridge.view.InputView;

public enum InputRetryOrNot {
    R,
    Q;

    public static void getRetryOrNot(BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge){
        String retryOrNot = InputView.readGameCommand();
        if (retryOrNot.equals(String.valueOf(InputRetryOrNot.R))){
            BridgeGame retryGame = new BridgeGame();

            retryGame.move(Application.bridgeLength, retryGame);
            return;
        }
        BridgeGameManager.finish("실패",upperBridge,lowerBridge);
    }
}

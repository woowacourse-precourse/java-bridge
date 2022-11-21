package bridge;

import java.util.Arrays;

public enum InputRetryOrNot {
    R,
    Q;


    public static void getRetryOrNot(String retryOrNot, BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge){

        if (retryOrNot.equals(String.valueOf(InputRetryOrNot.R))){
            BridgeGame retryGame = new BridgeGame();

            retryGame.move(Application.bridgeLength, retryGame);
            return;
        }
        newGame.finish("실패",upperBridge,lowerBridge);
        return;
    }
}

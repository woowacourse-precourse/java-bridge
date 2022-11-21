package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        int runCount = ZERO;
        int run = bridgeGame.run();
        if(run == ZERO) {
            bridgeGame.callFinalPrint();
            System.out.println();
            outputView.printWin();
        }
        while(run != ZERO){
            int isWin = bridgeGame.retry();
            runCount++;
            if( isWin == ZERO) {
                bridgeGame.callFinalPrint();
                System.out.println();
                outputView.printWin();
                break;
            }
            if(isWin == TWO){
                bridgeGame.callFinalPrint();
                System.out.println();
                outputView.printLose();
                runCount--;
                break;
            }
        }
        outputView.printRunCycle(runCount);
    }
}

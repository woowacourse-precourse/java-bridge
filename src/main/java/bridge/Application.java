package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int ZERO = 0;
    private static final int ERROR = 99;
    private static final int TWO = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        int runCount = ZERO;
        int run = bridgeGame.run();
        if (run == ZERO) {
            bridgeGame.callFinalPrint();
            System.out.println();
            outputView.printWin();
            outputView.printRunCycle(runCount);
        }
        while (run != ZERO && run != ERROR) {
            runCount++;
            int isWin = bridgeGame.retry();
            if (isWin == ERROR)
                break;
            if (isWin == ZERO) {
                bridgeGame.callFinalPrint();
                System.out.println();
                outputView.printWin();
                outputView.printRunCycle(runCount);
                return;
            }
            if (isWin == TWO) {
                bridgeGame.callFinalPrint();
                System.out.println();
                outputView.printLose();
                runCount--;
                outputView.printRunCycle(runCount);
                break;
            }
        }
    }
}


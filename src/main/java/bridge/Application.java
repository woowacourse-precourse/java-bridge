package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int ZERO = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        int runCount = ZERO;
        int run = bridgeGame.run();
        while(run != ZERO){
            runCount++;
            if(bridgeGame.retry() == ZERO)
                break;
        }
        outputView.printWin();
        outputView.printRunCycle(runCount);

    }
}

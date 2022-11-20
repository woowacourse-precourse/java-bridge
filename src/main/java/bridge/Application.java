package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;

import static bridge.controller.GameResult.gameResult;
import static bridge.controller.GameRun.gameRun;
import static bridge.controller.GameStart.gameStart;

public class Application {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static Bridge bridge;
    private static int retryCnt;

    public static void main(String[] args) {
        bridge = gameStart(bridgeMaker);
        retryCnt = gameRun(bridge);
        gameResult(retryCnt);
    }

}

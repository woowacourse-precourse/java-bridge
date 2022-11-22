package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.UserMovement;

import static bridge.controller.GameResult.gameResult;
import static bridge.controller.GameRun.gameRun;
import static bridge.controller.GameStart.gameStart;

/**
 * 다리 건너기 게임 어플리케이션
 */
public class Application {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static Bridge bridge;
    private static UserMovement userMovement = new UserMovement();
    private static int tryCnt;

    public static void main(String[] args) {
        bridge = gameStart(bridgeMaker);
        tryCnt = gameRun(userMovement, bridge);
        gameResult(userMovement, bridge, tryCnt);
    }

}

package bridge;

import bridge.domain.Bridge;
import bridge.domain.UserMovement;

import static bridge.controller.GameResult.gameResult;
import static bridge.controller.GameRun.gameRun;
import static bridge.controller.GameStart.gameStart;

/**
 * 다리 건너기 게임 어플리케이션
 */
public class Application {
    private static BridgeMaker bridgeMaker;
    private static Bridge bridge;
    private static UserMovement userMovement;

    public static void main(String[] args) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        userMovement = new UserMovement();
        bridge = gameStart(bridgeMaker);
        int tryCnt = gameRun(userMovement, bridge, 0);
        gameResult(userMovement, bridge, tryCnt);
    }

}

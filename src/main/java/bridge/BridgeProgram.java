package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.*;
import static bridge.InputView.*;
import static bridge.OutputView.printMap;
import static bridge.OutputView.printResult;

public class BridgeProgram {

    // 전체 프로그램을 가동하는 기능
    public static void runBridgeProgram() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        runBridgeGame(bridge,1);
    }
    
    public static void runBridgeGame(List<String> bridge, int tryCount) {
        List<String> moved = new ArrayList<>();
        do {
            String moving = readMoving();
            move(moved, moving);
            printMap(bridge, moved);
        } while (!isFinished(bridge, moved));

        if (!canRestartWhenFailed(bridge, moved, tryCount)) {
            printResult(bridge, moved, isArrivedDestination(bridge, moved) ,tryCount);
        }
    }

    public static boolean canRestartWhenFailed(List<String> bridge, List<String> moved, int tryCount) {
        if (isFailed(bridge, moved)) {
            String gameCommand = readGameCommand();
            if (gameCommand.equals("R")) {
                retry(bridge, tryCount);
                return true;
            }
        }
        return false;
    }
}

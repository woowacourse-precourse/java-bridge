package bridge.application;

import bridge.BridgeRandomNumberGenerator;
import bridge.common.message.ConsoleOut;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.InputView;
import bridge.domain.ProcessHelper;
import bridge.domain.vo.MatchResult;
import bridge.infra.ProcessHelperImpl;
import java.util.List;

public class BridgeGameProcess {

    private static ProcessHelper processHelper = new ProcessHelperImpl();
    private static InputView inputView = new InputView();

    public static void run() {
        ConsoleOut.GAME_START_MESSAGE.print();
        int bridgeSize = inputView.readBridgeSize(processHelper);
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        System.out.println(bridge); // 게임 보드 브릿지 생성
        while (true) {
            BridgeGame bridgeGame = new BridgeGame();
            for (int index = 0; index < bridgeSize; index++) {
                String moving = inputView.readMoving(processHelper);
                MatchResult matchResult = bridgeGame.move(bridge, moving, index);
                matchResult.printUpperSide();
                matchResult.printDownSide();
            }
        }
    }
}

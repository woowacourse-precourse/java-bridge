package bridge.application;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.common.message.ConsoleOut;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.InputView;
import bridge.domain.ProcessHelper;
import bridge.infra.ProcessHelperImpl;
import java.util.List;

public class BridgeGameProcess {

    private static ProcessHelper processHelper = new ProcessHelperImpl();
    private static BridgeNumberGenerator bridgeNumberGenerator =new BridgeRandomNumberGenerator();
    private static InputView inputView = new InputView();

    public static void run() {
        ConsoleOut.GAME_START_MESSAGE.print();
        ConsoleOut.INPUT_BRIDGE_LENGTH_MESSAGE.print();
        int bridgeSize = inputView.readBridgeSize(processHelper);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> strings = bridgeMaker.makeBridge(bridgeSize); // 게임 브릿지 생성
        System.out.println(strings);

    }
}

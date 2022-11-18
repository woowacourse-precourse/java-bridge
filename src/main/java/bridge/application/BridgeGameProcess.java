package bridge.application;

import bridge.common.message.ConsoleOut;
import bridge.domain.Bridge;
import bridge.domain.InputView;
import bridge.domain.ProcessHelper;
import bridge.infra.ProcessHelperImpl;

public class BridgeGameProcess {

    private static ProcessHelper processHelper = new ProcessHelperImpl();

    public static void run() {
        ConsoleOut.GAME_START_MESSAGE.print();
        InputView inputView = new InputView();
        int re = inputView.readBridgeSize(processHelper);
        Bridge.from(re);
    }
}

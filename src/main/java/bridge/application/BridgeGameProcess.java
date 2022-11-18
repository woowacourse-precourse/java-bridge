package bridge.application;

import bridge.common.message.ConsoleOut;
import bridge.domain.ProcessHelper;
import bridge.infra.ProcessHelperImpl;

public class BridgeGameProcess {

    private ProcessHelper processHelper = new ProcessHelperImpl();

    public static void run() {
        ConsoleOut.GAME_START_MESSAGE.print();
    }
}

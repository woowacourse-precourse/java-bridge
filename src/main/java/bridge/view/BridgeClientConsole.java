package bridge;

import bridge.view.ClientConsole;
import camp.nextstep.edu.missionutils.Console;

public class BridgeClientConsole implements ClientConsole {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}

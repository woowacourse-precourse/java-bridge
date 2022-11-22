package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class BridgeClientConsole implements ClientConsole {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}

package bridge.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleBridgeInput implements BridgeInput {
    @Override
    public String readData() {
        return Console.readLine();
    }
}

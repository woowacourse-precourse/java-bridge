package bridge.model.inputhandler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandlerImpl implements InputHandler {

    @Override
    public int inputBridgeSize() {
        return Integer.parseInt(Console.readLine());
    }
}

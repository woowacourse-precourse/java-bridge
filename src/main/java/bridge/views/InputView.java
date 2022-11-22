package bridge.views;

import static bridge.messages.InputMessage.GAME_COMMAND;
import static bridge.messages.InputMessage.INPUT_BRIDGE_BLOCK;
import static bridge.messages.InputMessage.INPUT_BRIDGE_LENGTH;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String inputBridgeSize = readLine();
        System.out.println();
        return inputBridgeSize;
    }

    public String readMoving() {
        System.out.println(INPUT_BRIDGE_BLOCK);
        return readLine();
    }

    public String readGameCommand() {
        System.out.println(GAME_COMMAND);
        return readLine();
    }


    private String readLine() {
        return Console.readLine();
    }
}

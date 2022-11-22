package bridge.view;

import static bridge.enums.InputMsg.*;
import static bridge.util.ConvertData.convertStringIntoInt;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println(LINE_BREAK.get() + MSG_INPUT_BRIDGE_SIZE.get());
        return convertStringIntoInt(Console.readLine());
    }

    public String readMoving() {
        System.out.println(LINE_BREAK.get() + MSG_INPUT_MOVING_CELL.get());
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(LINE_BREAK.get() + MSG_INPUT_GAME_RETRY.get());
        return Console.readLine();
    }
}

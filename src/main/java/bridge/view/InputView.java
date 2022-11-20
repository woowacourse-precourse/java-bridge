package bridge.view;

import static bridge.enums.InputMsg.*;
import static bridge.util.ConvertData.convertStringIntoInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(LINE_BREAK.get() + MSG_INPUT_BRIDGE_SIZE.get());
        return convertStringIntoInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(LINE_BREAK.get() + MSG_INPUT_MOVING_CELL.get());
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(LINE_BREAK.get() + MSG_INPUT_GAME_RETRY.get());
        return Console.readLine();
    }
}

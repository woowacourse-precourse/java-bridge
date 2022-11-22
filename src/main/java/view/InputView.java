package view;

import static bridge.constant.GameMessage.GAME_START_MESSAGE;
import static bridge.constant.GameMessage.INPUT_BRIDGE_LENGTH_MESSAGE;
import static bridge.constant.GameMessage.INPUT_SELECT_RETRY_MESSAGE;
import static bridge.constant.GameMessage.INPUT_SELECT_UPDOWN_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String length = Console.readLine();
        System.out.println();
        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_SELECT_UPDOWN_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_SELECT_RETRY_MESSAGE);
        return Console.readLine();
    }
}

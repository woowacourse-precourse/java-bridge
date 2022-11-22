package bridge;

import bridge.domain.BridgeGame;
import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private static final String rangeErrorMessage = "[ERROR] 다리길이는 3이상 20이하 입니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        InputViewType inputViewType = InputViewType.BRIDGE_SIZE;
        inputViewType.printMessage();
        while (true) {
            String input = getString(inputViewType);
            int number = Integer.parseInt(input);
            if (number >= MIN_RANGE && number <= MAX_RANGE) {
                return number;
            }
            System.out.println(rangeErrorMessage);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        InputViewType inputViewType = InputViewType.MOVING;
        inputViewType.printMessage();
        return getString(inputViewType);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        InputViewType inputViewType = InputViewType.GAME_COMMAND;
        inputViewType.printMessage();
        return getString(inputViewType);
    }

    private String getString(InputViewType inputViewType) {
        while(true) {
            try {
                String input = Console.readLine();
                inputViewType.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                inputViewType.printErrorMessage();
            }
        }
    }
}

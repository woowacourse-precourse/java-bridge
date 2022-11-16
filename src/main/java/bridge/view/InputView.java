package bridge.view;

import bridge.validator.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY_STRING = "";
    private static final String PRINT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_SELECT_MOVING_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println();
        System.out.println(PRINT_BRIDGE_SIZE);
        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY_STRING);;
        InputViewValidator.checkBridgeSizeIsNotNumber(userInput);

        int bridgeSize = Integer.parseInt(userInput);
        InputViewValidator.checkBridgeSizeNotInvalid(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println();
        System.out.println(PRINT_SELECT_MOVING_DIRECTION);

        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY_STRING);
        InputViewValidator.checkMovingCommandSize(userInput);
        InputViewValidator.checkMovingCommandUpperCase(userInput);
        InputViewValidator.checkMovingCommandCharacter(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

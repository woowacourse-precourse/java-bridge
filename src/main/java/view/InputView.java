package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import constant.NoticeMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static InputValidation inputValidation = new InputValidation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println(NoticeMessage.INPUT_BRIDGE_SIZE);
        String input = readLine();
        inputValidation.checkBlank(input);
        inputValidation.checkInteger(input);
        int bridgeSize = Integer.parseInt(input);
        inputValidation.checkBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println(NoticeMessage.INPUT_MOVING);
        String input = readLine();
        inputValidation.checkMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        System.out.println(NoticeMessage.INPUT_GAME_COMMAND);
        String input = readLine();
        inputValidation.checkGameCommand(input);
        return input;
    }
}

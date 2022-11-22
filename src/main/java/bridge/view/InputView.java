package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    int bridgeSize;
    String userInputMoving;
    String userInputCommand;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            bridgeSize = InputValidate.isValidSize(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        userInputMoving = Console.readLine();
        try {
            InputValidate.isValidMoving(userInputMoving);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
        return userInputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        userInputCommand = Console.readLine();
        try {
            InputValidate.isValidCommand(userInputCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return userInputCommand;
    }

}

package bridge;

import bridge.constants.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            new UserInputException().checkInputException(1, input);
            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            OutputView.printException(e);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String input = Console.readLine();
            new UserInputException().checkInputException(2, input);
            return input;
        }catch (IllegalArgumentException e){
            OutputView.printException(e);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        if (!new UserInputException().checkInputException(3, input)){
            throw new IllegalArgumentException(Message.COMMAND_ERROR_MESSAGE);
        }
        return input;
    }
}

package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements ConsoleInput, InputValidator {

    public BridgeSize readBridgeSize() {
        try {
            return BridgeSize.valueOf(input());
        } catch ( IllegalArgumentException ignored) {
            return readBridgeSize();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    @Override
    public  String input() {
        String input = Console.readLine().trim();
        validate(input);
        return input;
    }

    @Override
    public void validate(Object input) {
        if (input.equals("")){
            throw new InputException(InputException.EMPTY);
        }
    }
}

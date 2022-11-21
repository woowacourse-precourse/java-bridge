package bridge.presentation;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NUMBER_REGEX = "^[0-9]*$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.INTRO);
        System.out.println(Message.INPUT_SIZE);

        String line = Console.readLine();
        validateBridgeSize(line);
        
        return Integer.parseInt(line);
    }

    private void validateBridgeSize(String line) {
        if (!line.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("BridgeSize 값은 숫자만 입력될 수 있습니다.");
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
}

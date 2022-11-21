package bridge.views;

import bridge.exceptions.CustomIllegalStateException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends DefaultView {

    private static final String MSG_REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(MSG_REQUEST_BRIDGE_SIZE);
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new CustomIllegalStateException(
                    "자바 정수 범위 이내의 숫자를 입력해야 합니다."
            );
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

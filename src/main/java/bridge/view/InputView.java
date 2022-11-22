package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_BRIDGE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART_OR_END_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String inputLength = Console.readLine();
        inputLengthIsNumValidate(inputLength);
        return Integer.parseInt(inputLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_BRIDGE_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RESTART_OR_END_MESSAGE);
        return Console.readLine();
    }

    public void inputLengthIsNumValidate(String inputLength) throws IllegalArgumentException {
        for (char ch : inputLength.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR] 숫자인 값만 입력해야 합니다.");
            }
        }
    }
}

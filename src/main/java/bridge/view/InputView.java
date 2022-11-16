package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.\n";
    private static final String INPUT_BRIDGE_LOCATION = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n";
    private static final String INPUT_RESTART_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n";
    private static final String DATA_TYPE_ERR_MESSAGE = "[ERROR] 숫자가 아닙니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        return convertStringtoInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_BRIDGE_LOCATION);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RESTART_QUIT);
        return Console.readLine();
    }

    private static int convertStringtoInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATA_TYPE_ERR_MESSAGE);
        }
    }
}
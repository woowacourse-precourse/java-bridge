package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_GUIDE = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_SIZE_NOT_INTEGER_ERROR = "[ERROR] 다리 길이는 정수입니다.";
    private static final String BRIDGE_SIZE_RANGE_ERROR = "[ERROR] 다리 길이의 범위는 3 이상 20 이하입니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = getInput(BRIDGE_SIZE_GUIDE);
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        int size;
        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_INTEGER_ERROR);
        }
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR);
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

    /**
     * 안내 문구를 출력하고 사용자로부터 입력받은 문자열을 반환한다.
     *
     * @param guide 출력해줄 안내 문구
     * @return 사용자가 입력한 문자열 반환
     */
    public String getInput(String guide) {
        System.out.println(guide);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}

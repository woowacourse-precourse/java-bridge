package bridge;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String EMPTY_LINE = "";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 숫자만 입력 가능합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        System.out.println(EMPTY_LINE);

        String size = Console.readLine();
        validateSize(size);
        int bridgeSize = parseInt(size);

        return bridgeSize;
    }

    private void validateSize(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
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

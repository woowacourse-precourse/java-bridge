package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_DIRECTION_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        return validateSizeType(Console.readLine());
    }

    /**
     * 다리의 길이 형식을 검증한다.
     * @param size
     * @return
     */
    private int validateSizeType(String size) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(size);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
        }
        return bridgeSize;
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

    public void printSelectDirection() {
        System.out.println(BRIDGE_DIRECTION_SELECT_MESSAGE);
    }
}

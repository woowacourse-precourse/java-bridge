package bridge.view;

import bridge.BridgeValue;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_DIRECTION_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String BRIDGE_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
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
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            System.out.println(INPUT_TYPE_IS_NOT_PROPER);
            readBridgeSize();
        }
        return 0;
    }

    // TODO: 타입을 어떻게 검사할 것인가
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(BRIDGE_DIRECTION_SELECT_MESSAGE);
        return validateDirectionType(Console.readLine());
    }

    private String validateDirectionType(String direction) {
        if (!direction.equals(BridgeValue.LOWER_BRIDGE.getDirection()) && !direction.equals(BridgeValue.UPPER_BRIDGE.getDirection())) {
            throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
        }
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(BRIDGE_COMMAND_MESSAGE);
        return validateCommandType(Console.readLine());
    }

    // TODO: 검증 방식 고민
    private String validateCommandType(String command) {
        return command;
    }
}

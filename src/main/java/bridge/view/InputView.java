package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final Pattern BRIDGE_SIZE_REGX = Pattern.compile("\\d");
    private final String NOT_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String NOT_MOVING = "[ERROR] 이동할 칸은 \"U\" 또는 \"D\"만 가능합니다.";
    private final String BRIDGE_UP = "U";
    private final String BRIDGE_DOWN = "D";
    private final String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();

        validateBridgeSize(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING);
        String position = Console.readLine();
        validateMoving(position);
        return position;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!BRIDGE_SIZE_REGX.matcher(bridgeSize).matches()) {
            throw new IllegalArgumentException(NOT_BRIDGE_SIZE);
        }
    }

    private void validateMoving(String moving) {
        if (!(moving.equals(BRIDGE_UP) || moving.equals(BRIDGE_DOWN))) {
            throw new IllegalArgumentException(NOT_MOVING);
        }
    }
}

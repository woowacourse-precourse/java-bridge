package bridge.view;

import bridge.utils.ValidationUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_LENGTH = "\n다리의 길이를 입력해주세요.";

    public int printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
        return readBridgeSize();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        return inputBridgeSize();
    }

    private int inputBridgeSize() {
        while (true) {
            try {
                return getBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBridgeSize() {
        String bridgeSize = readLine();
        ValidationUtils.validateBridgeSize(bridgeSize);

        return Integer.parseInt(bridgeSize);
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

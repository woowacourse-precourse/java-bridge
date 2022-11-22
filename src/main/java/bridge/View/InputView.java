package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요";
    private static final String CHOOSE_BRIDGE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String BRIDGE_SIZE_OUT_OF_BOUND_ERROR = "[ERROR] 다리 길이는 3이상 20이하의 숫자만 가능합니다.";
    private static final String NOT_INTEGER_ERROR = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String BRIDGE_CHOOSE_OUT_OF_BOUND_ERROR = "[ERROR] U와 D 중 하나만 입력할 수 있습니다.";
    private static final String GAME_COMMAND_OUT_OF_BOUND_ERROR = "[ERROR] R과 Q 중 하나만 입력할 수 있습니다.";

    private InputView() {

    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() throws IllegalArgumentException{
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        return validateBridgeSize(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() throws IllegalArgumentException{
        System.out.println(CHOOSE_BRIDGE_MESSAGE);
        return validateBridgeChoose(Console.readLine());
    }

    /**
     * 입려받은 다리의 길이를 int 데이터로 바꾸고, 예외를 처리하는 메소드
     *
     * @param inputBridgeSize 입력받은 다리의 길이(String)
     * @return 설정할 다리의 길이(int)
     */
    private static int validateBridgeSize(String inputBridgeSize) {
        try {
            int bridgeSize = Integer.parseInt(inputBridgeSize);
            if (bridgeSize < 3 || bridgeSize > 20)
                throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_BOUND_ERROR);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
    }

    /**
     * 사용자가 입력한 '이동할 칸'이 적합한지 확인하는 메소드
     *
     * @param inputBridgeChoose 입력받은 '이동할 칸'
     * @return 예외처리를 마친 '이동할 칸'
     */
    private static String validateBridgeChoose(String inputBridgeChoose) throws IllegalArgumentException{
        if (inputBridgeChoose.length() != 1) {
            throw new IllegalArgumentException(BRIDGE_CHOOSE_OUT_OF_BOUND_ERROR);
        }
        if (!inputBridgeChoose.equals("U") && !inputBridgeChoose.equals("D")) {
            throw new IllegalArgumentException(BRIDGE_CHOOSE_OUT_OF_BOUND_ERROR);
        }
        return inputBridgeChoose;
    }
}
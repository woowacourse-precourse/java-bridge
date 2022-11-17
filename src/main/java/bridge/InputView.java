package bridge;

import bridge.util.ParsingUtils;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    // InputView의 패키지는 변경할 수 있다.
    // InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
    // 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println("\n다리의 길이를 입력해주세요.");
                int bridgeSize = ParsingUtils.stringToInt(Console.readLine());
                checkNumberRange(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkNumberRange(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
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

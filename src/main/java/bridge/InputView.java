package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView() {
    }

    private static class InputViewHelper {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHelper.INSTANCE;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
        }

        validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || 20 < bridgeSize) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
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

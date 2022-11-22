package bridge.view;

import bridge.exception.IllegalNumberRangeException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();

        validateBridgeSizeInputLength(input);
        int bridgeSize = getBridgeSize(input);
        validateSizeLimit(bridgeSize);

        return bridgeSize;
    }

    private void validateBridgeSizeInputLength(String input) {
        if(input.length() > 2) {
            throw new IllegalArgumentException("validateBridgeSizeInputLength");
        }
    }

    private void validateSizeLimit(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalNumberRangeException("범위를 벗어난 입력입니다. ", bridgeSize);
        }
    }

    private int getBridgeSize(String input) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("getBridgeSize");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();

        validateMovingInputLength(input);
        validateMovingSpace(input);
        return input;
    }

    private void validateMovingInputLength(String input) {
        if(input.length() != 1) {
            throw new IllegalArgumentException("validateMovingInputLength");
        }
    }

    private void validateMovingSpace(String input) {
        if(!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("validateMovingSpace");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }
}

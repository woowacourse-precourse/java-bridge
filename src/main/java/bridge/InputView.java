package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView output = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     * @return bridgeSize 다리의 길이
     */
    public int readBridgeSize() {
        try {
            int bridgeSize = validateSizeNotNumber(readLine());
            validateSizeOutOfRange(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            output.printError(e);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * @return 이동할 위치
     */
    public String readMoving() {

    try {
        return validateMovement(readLine());
    } catch (IllegalArgumentException e) {
        output.printError(e);
        return readMoving();
    }
}
    public String readGameCommand() {
        try {
            return validateGameCommand(readLine());
        } catch (IllegalArgumentException e) {
            output.printError(e);
            return readGameCommand();
        }
    }


    private int validateSizeNotNumber(String answer) {
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리 길이는 숫자를 입력해야 합니다.");
        }
    }

    private void validateSizeOutOfRange(int size) {
        if (size > BridgeMaker.MAX_BRIDGE_SIZE || size < BridgeMaker.MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private String validateMovement(String answer) {
        if (!(answer.equals("U") || answer.equals("D"))) {
            throw new IllegalArgumentException("이동할 칸은 'U' 또는 'D' 만 입력 가능합니다.");
        }
        return answer;
    }

    private String validateGameCommand(String answer) {
        if (!(answer.equals("R") || answer.equals("Q"))) {
            throw new IllegalArgumentException("커맨드는 'R' 또는 'Q' 만 입력 가능합니다.");
        }
        return answer;
    }
}
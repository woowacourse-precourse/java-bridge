package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int bridgeSize = validateSizeNotNumber(readLine());
            validateSizeOutOfRange(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            OutputView output = new OutputView();
            output.printError(e);
            return readBridgeSize();
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

    private int validateSizeNotNumber(String answer) {
        try{
            return Integer.parseInt(answer);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("다리 길이는 숫자를 입력해야 합니다.");
        }
    }

    private void validateSizeOutOfRange(int size) {
        if (size > BridgeMaker.MAX_BRIDGE_SIZE || size < BridgeMaker.MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}

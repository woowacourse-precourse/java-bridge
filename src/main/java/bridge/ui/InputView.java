package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

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

    /**
     * 사용자에게 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        validateNumber(bridgeSizeInput);
        validateBridgeSizeLength(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    /**
     * 검증 로직 : 숫자가 맞는지 검증한다.
     */
    private void validateNumber(String inputValue) {
        for (int i = 0; i < inputValue.length(); ++i) {
            if (Character.isDigit(inputValue.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
            }
        }
    }

    /**
     * 검증 로직 : 다리 길이가 일의 자리와 십의 자리 사이인지 검증한다.
     */
    private void validateBridgeSizeLength(String bridgeSizeInput) {
        if (bridgeSizeInput.length() != 1 && bridgeSizeInput.length() != 2) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 검증 로직 : 다리 길이 범위를 검증한다.
     */
    private void validateBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}

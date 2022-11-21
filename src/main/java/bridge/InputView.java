package bridge;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        System.out.println("다리 건너기 게임을 시작합니다.\n 다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        checkBridgeSizeValidation(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    public void checkBridgeSizeValidation(String bridgeSize) {

        checkBridgeSizeLength(bridgeSize);
        checkBridgeSizeInteger(bridgeSize);
        checkBridgeSizeNumber(bridgeSize);
    }

    private void checkBridgeSizeNumber(String bridgeSize) {

        int translatedBridgeSize = Integer.parseInt(bridgeSize);

        if (translatedBridgeSize < 3 || translatedBridgeSize > 20) {
            throw new IllegalArgumentException("3 ~ 20 사이의 값을 입력해야 합니다.");
        }
    }

    private void checkBridgeSizeInteger(String bridgeSize) {

        for (char argument : bridgeSize.toCharArray()) {
            if (argument < '0' || argument > '9') {
                throw new IllegalArgumentException("3 ~ 20 사이의 값을 입력해야 합니다.");
            }
        }
    }

    private void checkBridgeSizeLength(String bridgeSize) {

        int stringLength = bridgeSize.length();

        if (stringLength < 1 || stringLength > 2) {
            throw new IllegalArgumentException("3 ~ 20 사이의 값을 입력해야 합니다.");
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

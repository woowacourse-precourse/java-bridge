package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private Integer bridgeLength;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (bridgeLength == null) {
            receiveLength();
        }

        return bridgeLength;
    }

    private void receiveLength() {
        try {
            String bridgeSize = Console.readLine();
            int sizeNumber = makeSureNumber(bridgeSize);
            checkLengthRange(sizeNumber);
            bridgeLength = sizeNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private int makeSureNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void checkLengthRange(int input) throws IllegalArgumentException{
        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
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

package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_MIN = 3;
    private static final int BRIDGE_MAX = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        int bridgeSize = 0;
        try {
            bridgeSize = convertStringToInt(input);
            validBridgeLength(bridgeSize);
        } catch (IllegalArgumentException e) {
            this.readBridgeSize();
        }
        return bridgeSize;
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

    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validBridgeLength(int input) {
        if (input < BRIDGE_MIN || input > BRIDGE_MAX) {
            System.out.println("[ERROR] 다리 길이는 3이상 20이하만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}

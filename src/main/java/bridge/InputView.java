package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_SIZE_LOWER = 3;
    private static final int BRIDGE_SIZE_UPPER = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String inputBridgeSize = Console.readLine();
            validBridgeSize(inputBridgeSize);
            return Integer.parseInt(inputBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            readBridgeSize();
        }
        return 0;
    }

    private void validBridgeSize(String inputBridgeSize) {
        validIsNumber(inputBridgeSize);
        validBridgeSizeInRange(Integer.parseInt(inputBridgeSize));
    }

    private void validIsNumber(String number) {
        boolean check = number.chars()
                .allMatch(Character::isDigit);
        if (!check) {
            throw new IllegalArgumentException("입력한 값이 숫자가 아닙니다.");
        }
    }

    private void validBridgeSizeInRange(int number) {
        if (BRIDGE_SIZE_LOWER > number || number > BRIDGE_SIZE_UPPER) {
            throw new IllegalArgumentException("다리 길이가 3 이상 20 이하가 아닙니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String inputReadMoving = Console.readLine();
            validReadMoving(inputReadMoving);
            return inputReadMoving;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return readMoving();
        }
    }

    private void validReadMoving(String inputReadMoving) {
        if (!inputReadMoving.matches("^[D|U]$")) {
            throw new IllegalArgumentException("입력한 값이 D 또는 U가 아닙니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final int MIN_BRIDGE_SIZE = 3;
    private final int MAX_BRIDGE_SIZE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = parseInt(read());

        return bridgeSize;
    }

    private String read() {
        return Console.readLine();
    }

    private void validateBridgeSize(int bridgeSize) {
        if (!(bridgeSize >= MIN_BRIDGE_SIZE && bridgeSize <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return validateMoveType(read());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private int parseInt(String input) {
        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
        }
    }

    private String validateMoveType(String target) {
        if (!(target.equals("U") || target.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 수 있는 위치는 위(U) 혹은 아래(D) 뿐입니다.");
        }
        return target;
    }
}



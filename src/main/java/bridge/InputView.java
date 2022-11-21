package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RESTART_GAME_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final int BRIDGE_SIZE_MINIMUM = 1;
    private static final int BRIDGE_SIZE_MAXIMUM = Integer.MAX_VALUE;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        try {
            String size = Console.readLine();
            int integerSize = stringToInteger(size);
            if(!isInRange(integerSize)) {
                throw new IllegalArgumentException();
            }
            return integerSize;
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESTART_GAME_MESSAGE);
        return Console.readLine();
    }

    protected int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    protected boolean isInRange(int size) {
        if(size > BRIDGE_SIZE_MINIMUM && size <= BRIDGE_SIZE_MAXIMUM) {
            return true;
        }
        return false;
    }
}

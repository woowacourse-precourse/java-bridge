package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECT_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            System.out.println(INPUT_BRIDGE_SIZE);
            String bridgeSize = Console.readLine();
            if (!validateReadBridgeSize(bridgeSize))
                continue;
            return Integer.parseInt(bridgeSize);
        }
    }

    private boolean validateReadBridgeSize(String bridgeSize) {
        try {
            Validation.isInputIncludeCharacter(bridgeSize);
            Validation.isInputBetween3And20(Integer.parseInt(bridgeSize));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println(INPUT_SELECT_UP_OR_DOWN);
            String moving = Console.readLine();
            if (!validateReadMoving(moving))
                continue;
            return moving;
        }
    }

    private boolean validateReadMoving(String moving) {
        try {
            Validation.isInputUpOrDown(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

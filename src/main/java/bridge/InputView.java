package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);

        String bridgeSize = Console.readLine();
        InputValidator.inputBridgeSizeValidate(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);

        String moving = Console.readLine();
        InputValidator.inputMovingValidate(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

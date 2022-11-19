package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리 건너기 게임을 시작합니다.";

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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

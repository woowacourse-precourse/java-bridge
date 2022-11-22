package bridge.view;

import bridge.exception.BridgeError;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_TYPE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String REG_XP_DIGIT = "[0-9]+";

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String size = Console.readLine();
        isBridgeSizeDigit(size);
        return Integer.parseInt(size);
    }

    private void isBridgeSizeDigit(String length) {
        if (!length.matches(REG_XP_DIGIT)) {
            throw new IllegalArgumentException(BridgeError.BRIDGE_FORM.message());
        }
    }

    public String readMoving() {
        System.out.println(INPUT_MOVE_TYPE);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(INPUT_RETRY);
        return Console.readLine();
    }
}

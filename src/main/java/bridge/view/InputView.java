package bridge.view;

import bridge.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String INPUT_BRIDGE_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_GAME_RETRY_MESSAGE =
            "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            ExceptionMessage.INPUT_WRONG_BRIDGE_LENGTH_MESSAGE.throwException();
        }

        return 0;
    }

    public String readMoving() {
        System.out.println(INPUT_BRIDGE_MOVING_MESSAGE);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(INPUT_GAME_RETRY_MESSAGE);
        return Console.readLine();
    }
}

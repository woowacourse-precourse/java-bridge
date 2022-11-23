package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.support.ErrorMessage.INVALID_INPUT;

public class InputView {

    private static final String READ_BRIDGE_SIZE = "다리 길이를 입력해주세요.";
    private static final String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE);
        return toInteger(Console.readLine());
    }

    private Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT, e);
        }
    }

    public String readMoving() {
        System.out.println(READ_MOVING);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND);
        return Console.readLine();
    }
}

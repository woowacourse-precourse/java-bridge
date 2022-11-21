package bridge.ui;

import bridge.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE);
            int bridgeSize = Integer.parseInt(Console.readLine());
            System.out.println();
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONLY_NUMBER.getValue());
        }
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String moving = Console.readLine();
        return moving;
    }

    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        return gameCommand;
    }
}

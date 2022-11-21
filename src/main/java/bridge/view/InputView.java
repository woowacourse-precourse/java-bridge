package bridge.view;

import bridge.exception.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_OR_END = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);

        String bridgeSize = Console.readLine();
        InputValidator.inputBridgeSizeValidate(bridgeSize);
        System.out.println();
        return Integer.parseInt(bridgeSize);
    }

    public static String readMoving() {
        System.out.println(INPUT_MOVING);

        String moving = Console.readLine();
        InputValidator.inputMovingValidate(moving);
        return moving;
    }

    public static String readGameCommand() {
        System.out.println(INPUT_RETRY_OR_END);

        String command = Console.readLine();
        InputValidator.inputGameCommandValidate(command);
        return command;
    }
}

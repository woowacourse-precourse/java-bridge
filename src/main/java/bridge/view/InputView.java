package bridge.view;

import bridge.view.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;


public class InputView implements Input{
    private final InputValidation inputValidation;
    private final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public InputView(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        inputValidation.bridgeLen(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String command = Console.readLine();
        inputValidation.moveCommand(command);
        return command;
    }

    public String readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        String command = Console.readLine();
        inputValidation.retryCommand(command);
        return command;
    }
}

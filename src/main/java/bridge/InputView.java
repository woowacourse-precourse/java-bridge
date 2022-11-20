package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements Input{
    private final Validation validation;
    private final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public InputView(Validation validation) {
        this.validation = validation;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        validation.bridgeLen(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String command = Console.readLine();
        validation.moveCommand(command);
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        String command = Console.readLine();
        validation.retryCommand(command);
        return command;
    }
}

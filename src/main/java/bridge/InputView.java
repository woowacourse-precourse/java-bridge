package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RESTART_OR_END_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private InputValidation inputValidation;

    public InputView() {
        this.inputValidation = new InputValidation();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);

        String userInput = Console.readLine();
        inputValidation.bridgeSize(userInput);
        return Integer.valueOf(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT_MESSAGE);

        String userInput = Console.readLine();
        inputValidation.userMove(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESTART_OR_END_INPUT_MESSAGE);

        String userInput = Console.readLine();
        inputValidation.restartOrEnd(userInput);
        return userInput;
    }
}

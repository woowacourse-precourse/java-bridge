package bridge.view;

import bridge.model.bridge.Bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 비어있는 값, 적절하지 않은 타입으로 들어오는 값을 체크한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_PROMPT = "다리의 길이를 입력해주세요.";
    private static final String INVALID_BRIDGE_SIZE = String.format("다리 길이는 %d 부터 %d 사이의 숫자여야합니다.", Bridge.MIN_SIZE,
            Bridge.MAX_SIZE);

    private static final String MOVE_INPUT_PROMPT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ONLY_CAPITAL_LETTER = "대문자를 입력해주세요.";
    private static final String GAME_COMMAND_INPUT_PROMPT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_PROMPT);
        int inputSize = readLineAndParseInt();

        validateBridgeSize(inputSize);
        return inputSize;
    }

    private int readLineAndParseInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
    }

    private void validateBridgeSize(int inputSize) {
        if (inputSize < Bridge.MIN_SIZE || inputSize > Bridge.MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT_PROMPT);
        String command = Console.readLine();
        validateCapitalLetter(command);
        return command;
    }

    public void validateCapitalLetter(String command) {
        if (!command.matches("[A-Z]")) {
            throw new IllegalArgumentException(ONLY_CAPITAL_LETTER);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_COMMAND_INPUT_PROMPT);
        String command = Console.readLine();
        validateCapitalLetter(command);
        return command;
    }
}

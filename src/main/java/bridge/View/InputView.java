package bridge.View;

import bridge.Domain.InputConverter;
import bridge.Domain.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String INPUT_SELECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    /**
     * 다리의 길이를 입력받는다.
     */
    public void printStartMessage() {
        System.out.println(START_GAME);
    }

    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println(INPUT_BRIDGE_SIZE);

        String input = readLine();

        try {
            int bridgeSize = InputConverter.convertToInt(input);

            return bridgeSize;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }


    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println(INPUT_SELECTION);
        String input = readLine();

        try {
            InputValidator.validateSelectionInput(input);

            return input;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        System.out.println(INPUT_COMMAND);

        String input = readLine();
        try {
            InputValidator.validateCommandInput(input);

            return input;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }
}

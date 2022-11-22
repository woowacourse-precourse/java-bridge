package bridge.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.Util.InputConverter;
import bridge.Util.InputValidator;



public class InputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public void printStartMessage() {
        System.out.println(START_GAME);
        System.out.println();
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

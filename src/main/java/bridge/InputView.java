package bridge;

import bridge.constant.BridgeMoveCommand;
import bridge.constant.BridgeRetryCommand;
import bridge.constant.InputValidationError;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String MENT_READ_BRIDGE_SIZE = "다리의 길이를 입력해 주세요.";
    private static final String MENT_READ_MOVE =
            "이동할 칸을 선택해 주세요. (위: " +
                    BridgeMoveCommand.MOVE_UP.command +
                    ", 아래: " +
                    BridgeMoveCommand.MOVE_DOWN.command +
                    ")";

    private static final String MENT_READ_COMMAND =
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " +
                    BridgeRetryCommand.RETRY.command +
                    ", 종료: " +
                    BridgeRetryCommand.QUIT.command +
                    ")";
    private InputValidator validator;

    public InputView() {
        this.validator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println(MENT_READ_BRIDGE_SIZE);
        String cmd = Console.readLine();
        int parsedCmd = validator.validateBridgeSizeParsable(cmd);
        validator.validateBridgeSize(parsedCmd);
        return parsedCmd;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println(MENT_READ_MOVE);
        String cmd = Console.readLine();
        validator.validateMove(cmd);
        return cmd;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        System.out.println(MENT_READ_COMMAND);
        String cmd = Console.readLine();
        validator.validateGameCommand(cmd);
        return cmd;
    }
}

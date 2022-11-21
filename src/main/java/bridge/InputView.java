package bridge;

import bridge.valid.BridgeSizeValidator;
import bridge.valid.GameCommandValidator;
import bridge.valid.InputValidator;
import bridge.valid.MovingValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";

    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);

        InputValidator inputValidator = new BridgeSizeValidator();
        String validInput = inputValidator.getValidInput();
        return Integer.parseInt(validInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_INPUT_MESSAGE);

        InputValidator inputValidator = new MovingValidator();
        return inputValidator.getValidInput();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_COMMAND_INPUT_MESSAGE);

        InputValidator inputValidator = new GameCommandValidator();
        return inputValidator.getValidInput();
    }
}

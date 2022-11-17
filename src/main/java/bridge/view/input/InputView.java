package bridge.view.input;

import bridge.view.output.OutputView;
import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public InputView() {
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printBridgeSizeRequestMessage();
        String bridgeSize = Console.readLine();
        inputValidator.validateBridegeSize(bridgeSize);
        outputView.printEnter();
        return parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMovingRequestMessage();
        String moving = Console.readLine();
        inputValidator.validateMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printGameCommandRequestMessage();
        String gameCommand = Console.readLine();
        inputValidator.validateGameCommand(gameCommand);
        return gameCommand;
    }
}

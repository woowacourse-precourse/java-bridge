package bridge.view.input;

import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import bridge.view.output.OutputView;
import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.vo.BridgeSize.createBridgeSize;
import static bridge.domain.vo.GameCommand.createGameCommand;
import static bridge.domain.vo.Moving.createMoving;

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
    public BridgeSize readBridgeSize() {
        outputView.printBridgeSizeRequestMessage();
        String bridgeSizeInput = Console.readLine();
        BridgeSize bridgeSize = createBridgeSize(bridgeSizeInput);
        outputView.printEnter();
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        outputView.printMovingRequestMessage();
        String movingInput = Console.readLine();
        return createMoving(movingInput);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        outputView.printGameCommandRequestMessage();
        String gameCommandInput = Console.readLine();
        return createGameCommand(gameCommandInput);
    }
}

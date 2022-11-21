package bridge.view;

import static bridge.BridgeMaker.convertStringToInt;
import static bridge.BridgeMaker.validateBridgeSizeRange;
import static bridge.BridgeMaker.validateBridgeSizeType;

import bridge.model.GameCommand;
import bridge.model.Position;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            outputView.printBridgeSizeInput();
            String input = Console.readLine();
            validateBridgeSizeType(input);
            int bridgeSize = convertStringToInt(input);
            validateBridgeSizeRange(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Position readMoving() {
        try {
            outputView.printMoveInput();
            return Position.from(Console.readLine());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
            outputView.printGameCommandInput();
            return GameCommand.from(Console.readLine());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readGameCommand();
        }
    }


}

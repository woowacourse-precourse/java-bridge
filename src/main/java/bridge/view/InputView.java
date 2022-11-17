package bridge.view;

import bridge.dto.BridgeSizeDTO;
import bridge.dto.GameCommandDTO;
import bridge.dto.MovingDTO;
import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.InputSelectCharValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MOVING_SELECT_CHAR_VALIDATE_NUMBER = 1;
    private static final int RETRY_SELECT_CHAR_VALIDATOR_NUMBER = 2;
    
    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeDTO readBridgeSize(final OutputView outputView) {
        printBridgeSizeInputMessage(outputView);
        try {
            final String inputBridgeSize = Console.readLine();
            InputBridgeSizeValidator.validate(inputBridgeSize);
            return new BridgeSizeDTO(Integer.parseInt(inputBridgeSize));
        } catch (final IllegalArgumentException raisedException) {
            printErrorMessage(outputView, raisedException);
            return readBridgeSize(outputView);
        }
    }
    
    private void printBridgeSizeInputMessage(final OutputView outputView) {
        outputView.printBridgeSizeInputMessage();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MovingDTO readMoving(final OutputView outputView) {
        printMovingInputMessage(outputView);
        try {
            final String inputMoving = Console.readLine();
            InputSelectCharValidator.validate(inputMoving, MOVING_SELECT_CHAR_VALIDATE_NUMBER);
            return new MovingDTO(inputMoving);
        } catch (final IllegalArgumentException raisedException) {
            printErrorMessage(outputView, raisedException);
            return readMoving(outputView);
        }
    }
    
    private void printMovingInputMessage(final OutputView outputView) {
        outputView.printMovingInputMessage();
    }
    
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommandDTO readGameCommand(final OutputView outputView) {
        printGameCommandInputMessage(outputView);
        try {
            final String inputGameCommand = Console.readLine();
            InputSelectCharValidator.validate(inputGameCommand, RETRY_SELECT_CHAR_VALIDATOR_NUMBER);
            return new GameCommandDTO(inputGameCommand);
        } catch (final IllegalArgumentException raisedException) {
            printErrorMessage(outputView, raisedException);
            return readGameCommand(outputView);
        }
    }
    
    private void printGameCommandInputMessage(final OutputView outputView) {
        outputView.printGameCommandInputMessage();
    }
    
    private void printErrorMessage(final OutputView outputView, final IllegalArgumentException raisedException) {
        outputView.printErrorMessage(raisedException);
    }
}

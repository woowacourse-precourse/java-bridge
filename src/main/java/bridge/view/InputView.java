package bridge.view;

import bridge.dto.BridgeSizeDTO;
import bridge.dto.GameCommandDTO;
import bridge.dto.MovingDTO;
import bridge.validator.CommandValidatorKey;
import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.InputCommandValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeDTO readBridgeSize(final OutputView outputView) {
        printBridgeSizeInputMessage(outputView);
        try {
            final String inputBridgeSize = userInput();
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
            final String inputMoving = userInput();
            InputCommandValidator.validate(inputMoving, CommandValidatorKey.MOVING_COMMAND_VALIDATOR);
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
            final String inputGameCommand = userInput();
            InputCommandValidator.validate(inputGameCommand, CommandValidatorKey.RETRY_COMMAND_VALIDATOR);
            return new GameCommandDTO(inputGameCommand);
        } catch (final IllegalArgumentException raisedException) {
            printErrorMessage(outputView, raisedException);
            return readGameCommand(outputView);
        }
    }
    
    private void printGameCommandInputMessage(final OutputView outputView) {
        outputView.printGameCommandInputMessage();
    }
    
    private String userInput() {
        return Console.readLine();
    }
    
    private void printErrorMessage(final OutputView outputView, final IllegalArgumentException raisedException) {
        outputView.printErrorMessage(raisedException);
    }
}

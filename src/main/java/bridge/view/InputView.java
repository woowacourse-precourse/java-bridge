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
    private static final int MOVING_SELECT_CHAR_VALIDATOR_NUMBER = 1;
    private static final int RETRY_SELECT_CHAR_VALIDATOR_NUMBER = 2;
    
    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeDTO readBridgeSize(final OutputView outputView) {
        printBridgeSizeInputMessage(outputView);
        final String inputBridgeSize = Console.readLine();
        try {
            InputBridgeSizeValidator.validate(inputBridgeSize);
            return new BridgeSizeDTO(Integer.parseInt(inputBridgeSize));
        } catch (final IllegalArgumentException raisedException) {
            System.out.println(raisedException.getMessage());
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
            InputSelectCharValidator.validate(inputMoving, MOVING_SELECT_CHAR_VALIDATOR_NUMBER);
            return new MovingDTO(inputMoving);
        } catch (final IllegalArgumentException raisedException) {
            System.out.println(raisedException.getMessage());
            return readMoving(outputView);
        }
    }
    
    private void printMovingInputMessage(final OutputView outputView) {
        outputView.printMovingInputMessage();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommandDTO readGameCommand() {
        final String inputGameCommand = Console.readLine();
        
        return new GameCommandDTO(inputGameCommand);
    }
}

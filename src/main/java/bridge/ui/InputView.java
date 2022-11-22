package bridge.ui;

import bridge.domain.validator.BridgeSizeInputValidator;
import bridge.domain.validator.ContinueInputValidator;
import bridge.domain.validator.MovingInputValidator;
import bridge.util.Commands;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeSizeInputValidator sizeInputValidator;
    private final ContinueInputValidator continueInputValidator;
    private final MovingInputValidator movingInputValidator;
    private final OutputView out;

    public InputView(OutputView out) {
        this.out = out;
        this.sizeInputValidator = new BridgeSizeInputValidator();
        this.continueInputValidator = new ContinueInputValidator();
        this.movingInputValidator = new MovingInputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        out.printMessage(Commands.REQUEST_BRIDGE_SIZE.message());
        String bridgeSize = Console.readLine();
        try {
            sizeInputValidator.validate(bridgeSize);
            return Integer.parseInt(bridgeSize.trim());
        } catch (IllegalArgumentException e) {
            out.printMessage(e.getMessage());
        }
        return -1;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        out.printMessage(Commands.REQUEST_MOVING.message());
        String moving = Console.readLine();
        try {
            movingInputValidator.validate(moving);
            return moving.trim();
        } catch (IllegalArgumentException e) {
            out.printMessage(e.getMessage());
        }
        return "error";
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readContinue() {
        out.printMessage(Commands.REQUEST_CONTINUE.message());
        String choice = Console.readLine();
        try {
            continueInputValidator.validate(choice);
            return choice.trim();
        } catch (IllegalArgumentException e) {
            out.printMessage(e.getMessage());
        }
        return "error";
    }
}

package bridge.view;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;
import bridge.constant.Messages;
import bridge.domain.BridgeSize;
import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public BridgeSize readBridgeSize() {
        System.out.println(Messages.BRIDGE_SIZE_INPUT_MESSAGE);
        return new BridgeSize(Console.readLine());
    }

    public String readMoving() {
        System.out.println(Messages.MOVING_MESSAGE);
        String movingInput = Console.readLine();
        validMoving(movingInput);
        return movingInput;
    }

    public Command readGameCommand() {
        System.out.println(Messages.RETRY_MESSAGE);
        return new Command(Console.readLine());
    }

    private void validMoving(String moving) {
        if (!moving.equals(Constant.UP) && !moving.equals(Constant.DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVING_VALUE.getMessage());
        }
    }

}

package bridge.view.inputview;

import bridge.system.validation.InputToBridgeSizeValidator;
import bridge.system.validation.InputToCommandValidator;
import bridge.system.validation.InputToMovingPointValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements InputViewInterface {

    /**
     * 다리의 길이를 입력받는다.
     */
    @Override
    public int readBridgeSize() {
        String input = readInput();
        InputToBridgeSizeValidator.validate(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    @Override
    public String readMoving() {
        String input = readInput();
        InputToMovingPointValidator.validate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    @Override
    public String readGameCommand() {
        String input = readInput();
        InputToCommandValidator.validate(input);
        return input;
    }

    protected String readInput() {
        return Console.readLine();
    }
}

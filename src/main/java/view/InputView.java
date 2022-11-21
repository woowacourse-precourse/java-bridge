package view;

import camp.nextstep.edu.missionutils.Console;
import util.validator.BridgeSizeValidator;
import util.ConverterUtil;
import util.validator.GameCommandValidator;
import util.validator.MovingValidator;

public class InputView {
    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public int readBridgeSize() throws IllegalArgumentException {
        String size = Console.readLine();
        BridgeSizeValidator.isValid(size);
        return ConverterUtil.convertStringToInt(size);
    }

    public String readMoving() throws IllegalArgumentException {
        String moving = ConverterUtil.convertToUpperCase(Console.readLine());
        MovingValidator.isValid(moving);
        return moving;
    }

    public String readGameCommand() throws IllegalArgumentException {
        String gameCommand = ConverterUtil.convertToUpperCase(Console.readLine());
        GameCommandValidator.isValid(gameCommand);
        return gameCommand;
    }
}

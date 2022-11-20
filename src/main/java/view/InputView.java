package view;

import camp.nextstep.edu.missionutils.Console;
import util.BridgeSizeValidator;
import util.Converter;
import util.GameCommandValidator;
import util.MovingValidator;

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
        return Converter.convertStringToInt(size);
    }

    public String readMoving() throws IllegalArgumentException {
        String moving = Converter.convertToUpperCase(Console.readLine());
        MovingValidator.isValid(moving);
        return moving;
    }

    public String readGameCommand() throws IllegalArgumentException {
        String gameCommand = Converter.convertToUpperCase(Console.readLine());
        GameCommandValidator.isValid(gameCommand);
        return gameCommand;
    }
}

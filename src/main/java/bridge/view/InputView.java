package bridge.view;

import bridge.constant.GameCommand;
import bridge.constant.InputMessage;
import bridge.constant.MoveCommand;
import bridge.domain.BridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final InputViewConverter inputValueConverter;

    public InputView(InputViewConverter inputValueConverter) {
        this.inputValueConverter = inputValueConverter;
    }

    public BridgeSizeValidator bridgeSize() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.bridgeSize(valueForBridgeSize()));
    }

    private String valueForBridgeSize() {
        System.out.println(InputMessage.INPUT_BRIDGE_LENGTH_MESSAGE.getMessage());
        return Console.readLine();
    }

    public MoveCommand moveCommand() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.moveCommands(valueForMoveCommand()));
    }

    private String valueForMoveCommand() {
        System.out.println(InputMessage.INPUT_CHOOSE_LOCATION_MESSAGE.getMessage());
        return Console.readLine();
    }

    public GameCommand gameCommand() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.gameCommands(valueForGameCommand()));
    }

    private String valueForGameCommand() {
        System.out.println(InputMessage.INPUT_RETRY_OR_QUIT_MESSAGE.getMessage());
        return Console.readLine();
    }

    private <T> T repeatInputUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}

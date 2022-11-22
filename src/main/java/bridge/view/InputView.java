package bridge.view;

import bridge.Env;
import bridge.Lang;
import bridge.type.PositionType;
import bridge.util.Console;
import bridge.util.Validator;
import bridge.util.Parser;
import java.util.List;

public class InputView {
    public int readBridgeSize() {
        try {
            return this.validateReadBridgeSize();
        } catch (IllegalArgumentException exception) {
            Console.printError(exception.getMessage());
            return this.readBridgeSize();
        }
    }

    private int validateReadBridgeSize() {
        String response = Console.readLine(Lang.get(Lang.INPUT_BRIDGE_SIZE));
        Validator.checkConsoleInputNumberInRange(
                List.of(Env.MIN_SIZE_OF_BRIDGE, Env.MAX_SIZE_OF_BRIDGE),
                response
        );

        return Parser.toIntFrom(response);
    }

    public PositionType readMoving() {
        try {
            return this.validateReadMoving();
        } catch (IllegalArgumentException exception) {
            Console.printError(exception.getMessage());
            return this.readMoving();
        }
    }

    private PositionType validateReadMoving() {
        String response = this.getMovingResponse();
        Validator.checkConsoleCommandIsCorrect(
                List.of(Env.CODE_OF_UP, Env.CODE_OF_DOWN),
                response
        );

        return PositionType.build(response);
    }

    private String getMovingResponse() {
        return Console.readLine(Lang.format(
                Lang.SELECT_SLAB,
                Env.CODE_OF_UP,
                Env.CODE_OF_DOWN
        ));
    }

    public boolean readGameCommand() {
        try {
            return this.validateReadGameCommand();
        } catch (IllegalArgumentException exception) {
            Console.printError(exception.getMessage());
            return this.readGameCommand();
        }
    }

    private boolean validateReadGameCommand() {
        String response = this.getGameCommandResponse();
        Validator.checkConsoleCommandIsCorrect(
                List.of(Env.CODE_OF_RETRY, Env.CODE_OF_QUIT),
                response
        );

        return response.equals(Env.CODE_OF_RETRY);
    }

    private String getGameCommandResponse() {
        return Console.readLine(Lang.format(
                Lang.SELECT_RETRY_OR_QUIT,
                Env.CODE_OF_RETRY,
                Env.CODE_OF_QUIT
        ));
    }
}

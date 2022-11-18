package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import java.util.function.Supplier;

public class InputDataConverter {

    private static final String ERROR_PREFIX = "[ERROR] ";

    BridgeSize bridgeSize(Supplier<String> consumer) {
        try {
            return new BridgeSize(consumer.get());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return bridgeSize(consumer);
        }
    }

    MoveCommands moveCommand(Supplier<String> consumer) {
        try {
            return MoveCommands.of(consumer.get());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return moveCommand(consumer);
        }
    }

    GameCommands gameCommand(Supplier<String> consumer) {
        try {
            return GameCommands.of(consumer.get());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return gameCommand(consumer);
        }
    }
}

package bridge.domain;

import bridge.domain.exception.NotExistCommandException;
import bridge.utils.Constants;
import java.util.Objects;

public class MovingCommand {

    private String movingCommand;

    public MovingCommand() {

    }

    private MovingCommand(String input) {
        if (!isValidateRange(input)) {
            throw new NotExistCommandException();
        }

        this.movingCommand = input;
    }

    private boolean isValidateRange(String input) {
        return Objects.equals(input, Constants.UP_SITUATION) || Objects.equals(input,
            Constants.DOWN_SITUATION);
    }

    public static MovingCommand from(String movingCommand) {
        return new MovingCommand(movingCommand);
    }

    public String getMovingCommand() {
        return this.movingCommand;
    }

}

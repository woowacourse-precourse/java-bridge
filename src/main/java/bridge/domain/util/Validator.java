package bridge.domain.util;

import bridge.domain.Direction;
import bridge.domain.GameCommand;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern pattern = Pattern.compile("^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$");

    //TODO : 예외 처리 분리
    public void validateBridgeSize(String bridgeSize) {
        if (!pattern.matcher(bridgeSize).find()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateMoving(String moving) {
        Direction.from(moving);
    }

    public void validateGameCommand(String gameCommand) {
        GameCommand.from(gameCommand);
    }
}

package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.Constants;
import java.util.Objects;

public class BridgeGame {

    public static BridgeMatchResult move(String bridgeStep, MovingCommand movingCommand) {
        return matchStep(bridgeStep, movingCommand);
    }

    public static boolean retry(GameCommand gameCommand) {
        return Objects.equals(gameCommand.getGameCommand(), Constants.RESTART);
    }

    public static Bridge generateBridge(SizeOfBridge sizeOfBridge) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return new Bridge(bridgeMaker.makeBridge(sizeOfBridge.getSize()));
    }

    private static BridgeMatchResult matchStep(String bridgeStep, MovingCommand movingCommand) {
        String command = movingCommand.getMovingCommand();

        if (Objects.equals(bridgeStep, command)) {
            return getMatchResult(command);
        }
        return getMissMatchResult(command);
    }

    private static BridgeMatchResult getMatchResult(String command) {
        if (Objects.equals(command, Constants.UP_SITUATION)) {
            return BridgeMatchResult.UP_RIGHT;
        }
        return BridgeMatchResult.DOWN_RIGHT;
    }

    private static BridgeMatchResult getMissMatchResult(String command) {
        if (Objects.equals(command, Constants.UP_SITUATION)) {
            return BridgeMatchResult.UP_WRONG;
        }
        return BridgeMatchResult.DOWN_WRONG;
    }
}

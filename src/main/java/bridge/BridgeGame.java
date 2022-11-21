package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMatchResult;
import bridge.domain.MovingCommand;
import bridge.domain.SizeOfBridge;
import bridge.utils.Constants;
import java.util.Objects;

public class BridgeGame {

    public static BridgeMatchResult move(String bridgeStep, MovingCommand movingCommand) {
        return matchStep(bridgeStep, movingCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public static Bridge generateBridge(SizeOfBridge sizeOfBridge) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return new Bridge(bridgeMaker.makeBridge(sizeOfBridge.getSize()));
    }

    public static BridgeMatchResult matchStep(String bridgeStep, MovingCommand movingCommand) {
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

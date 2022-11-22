package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridges;

    private BridgeGame(final List<String> bridges) {
        this.bridges = bridges;
    }

    public static BridgeGame of(final int number, BridgeNumberGenerator generator) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return new BridgeGame(bridgeMaker.makeBridge(number));
    }

    public List<String> move(final int currentPosition, final String command) {
        String currentAnswer = bridges.get(currentPosition);
        return BridgePosition.compare(currentAnswer, command);
    }

    public boolean retry(final String gameCommand) {
        return GameCommand.isRetryCommand(gameCommand);
    }

    public boolean isSuccess(final List<String> result) {
        return BridgePosition.isSuccess(result);
    }
}

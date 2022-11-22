package bridge.domain;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import java.util.Queue;

class BridgeGameTest {

    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public void init(Queue<Integer> numbers) {
        bridgeMaker = new BridgeMaker(numbers::poll);
        bridgeGame = new BridgeGame(bridgeMaker);
    }
}
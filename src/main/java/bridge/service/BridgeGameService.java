package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Result;
import java.util.List;

public class BridgeGameService {

    private final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private final BridgeMaker maker = new BridgeMaker(generator);
    private BridgeGame game;

    public void makeBridge(int size) {
        List<String> bridge = maker.makeBridge(size);
        game = new BridgeGame(bridge);
    }

    public Result move(String direction) {
        game.move(direction);
        return game.getResult();
    }

    public void retry() {
        game.retry();
    }

    public Result getResult() {
        return game.getResult();
    }
}

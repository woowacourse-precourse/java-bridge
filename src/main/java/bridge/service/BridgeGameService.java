package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.State;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {

    private final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private final BridgeMaker maker = new BridgeMaker(generator);
    private List<String> bridge;
    private List<String> input = new ArrayList<>();
    private BridgeGame game = new BridgeGame();

    public void makeBridge(int size) {
        bridge = maker.makeBridge(size);
    }

    public void move(String direction) {
        input.add(direction);
        game.move(bridge, direction);
    }

    public boolean isEnd() {
        return game.getGameState() != State.Progress;
    }

    public boolean isWin() {
        return game.getGameState() == State.Win;
    }

    public void retry() {
        input = new ArrayList<>();
        game.retry();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getInput() {
        return input;
    }

    public BridgeGame getGame() {
        return game;
    }
}

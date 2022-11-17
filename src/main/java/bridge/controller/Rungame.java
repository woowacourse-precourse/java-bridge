package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GameDTO;
import bridge.view.InputView;

import java.util.List;

public class Rungame {
    private static InputView input = new InputView();
    private GameDTO game;
    public Rungame() {
    }

    public void rungame() {
        int length = input.readBridgeSize();
        game = new GameDTO(getBridge(length));
    }
    private List<String> getBridge(int length) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(length);
        return bridge;
    }
}

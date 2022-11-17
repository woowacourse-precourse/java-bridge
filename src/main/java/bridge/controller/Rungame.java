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
        rungame();
    }

    private void rungame() {
        makebrige();
    }
    private void makebrige() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int length = input.readBridgeSize();

        List<String> bridge = maker.makeBridge(length);
        this.game = new GameDTO(bridge);
        System.out.println(bridge);
    }
}

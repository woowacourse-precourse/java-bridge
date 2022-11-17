package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GameDTO;
import bridge.view.InputView;
import bridge.view.PrintSentence;

import java.util.List;

public class Rungame {

    private GameDTO game;
    private static InputView input = new InputView();

    public Rungame() {
        startGame();
    }

    public void startGame() {
        getInput();
    }

    public void getInput() {
        System.out.println(PrintSentence.START.getSentence());
        int length = input.readBridgeSize();
        this.game = new GameDTO(getBridge(length));
    }

    private List<String> getBridge(int length) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(length);
        return bridge;
    }


}

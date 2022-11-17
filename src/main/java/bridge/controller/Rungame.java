package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.PrintSentence;

import java.util.List;

public class Rungame {
    private BridgeGame game;
    public Rungame() {
        startGame();
    }

    public void startGame() {
        game = new StartGame().getInput();
    }




}

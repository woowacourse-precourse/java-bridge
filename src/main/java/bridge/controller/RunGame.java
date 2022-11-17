package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.PrintSentence;

import java.util.List;

public class RunGame {
    private BridgeGame game;
    public RunGame() {
        startGame();
    }

    public void startGame() {
        game = new StartGame().getInput();
    }




}

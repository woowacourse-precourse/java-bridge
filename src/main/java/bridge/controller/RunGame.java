package bridge.controller;

import bridge.model.BridgeGame;

public class RunGame {
    private BridgeGame game;
    public RunGame() {
        game = new StartGame().getInput();
        System.out.println(game.getBridge());
        new ProgressGame(game);
    }
}

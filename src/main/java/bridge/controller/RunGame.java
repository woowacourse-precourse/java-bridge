package bridge.controller;

import bridge.model.BridgeGame;

public class RunGame {
    private BridgeGame game;
    public RunGame() {
        try {
            game = new StartGame().getInput();
            new ProgressGame(game);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

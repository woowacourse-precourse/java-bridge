package bridge.controller;

import bridge.service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void play() {
        gameService.gameStart();
        gameService.runGame();
        gameService.endGame();
    }
}

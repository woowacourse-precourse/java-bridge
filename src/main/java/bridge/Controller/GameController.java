package bridge.Controller;

import bridge.Controller.Service.BridgeGameService;
import bridge.Controller.Service.EndGameService;
import bridge.Controller.Service.StartGameService;
import bridge.Domain.BridgeGame;

public class GameController {
    private StartGameService startGameService;
    private BridgeGameService bridgeGameService;
    private EndGameService endGameService;
    private BridgeGame bridgeGame;

    public GameController() {
        this.startGameService = new StartGameService();
    }

    public void play() {
        try {
            beginBridgeGame();
            playGame();
            endGameService.endGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void beginBridgeGame() throws IllegalArgumentException {
        this.bridgeGame = startGameService.startGame();
        this.bridgeGameService = new BridgeGameService(bridgeGame);
        this.endGameService = new EndGameService(bridgeGame);
    }


    public void playGame() throws IllegalArgumentException {
        if(!bridgeGameService.severalPhaseBridgeGame() && endGameService.isGameRestart()) {
            endGameService.restartGame();
            playGame();
        }
    }
}

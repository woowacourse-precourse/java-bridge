package bridge.Controller;

import bridge.Controller.Service.BridgeGameService;
import bridge.Controller.Service.EndGameService;
import bridge.Controller.Service.StartGameService;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeGame;
import bridge.Domain.GameResultGenerator;
import bridge.Domain.Player;

public class GameController {
    private StartGameService startGameService;
    private BridgeGameService bridgeGameService;
    private EndGameService endGameService;

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
        Bridge bridge = startGameService.startGame();
        Player player = new Player(bridge);
        GameResultGenerator gameResultGenerator = new GameResultGenerator();
        BridgeGame bridgeGame = new BridgeGame(player, gameResultGenerator);
        this.bridgeGameService = new BridgeGameService(bridgeGame, player);
        this.endGameService = new EndGameService(bridgeGame, gameResultGenerator);
    }


    public void playGame() throws IllegalArgumentException {
        if (!bridgeGameService.severalPhaseBridgeGame() && endGameService.isGameRestart()) {
            endGameService.restartGame();
            playGame();
        }
    }
}

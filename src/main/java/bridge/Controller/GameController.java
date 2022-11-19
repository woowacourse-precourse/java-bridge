package bridge.Controller;

import bridge.Controller.Service.BridgeGameService;
import bridge.Controller.Service.EndGameService;
import bridge.Controller.Service.StartGameService;
import bridge.Domain.BridgeGame;
import bridge.Domain.GameResult;
import bridge.Domain.GameResultGenerator;

public class GameController {
    private StartGameService startGameService;
    private BridgeGameService bridgeGameService;
    private EndGameService endGameService;
    private GameResultGenerator gameResultGenerator;
    private BridgeGame bridgeGame;

    public GameController() {
        this.gameResultGenerator = new GameResultGenerator();
        this.startGameService = new StartGameService(gameResultGenerator);
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

    public boolean playBridgeGame() throws IllegalArgumentException {
        while(true) {
            bridgeGameService.onePhaseBridgeGame();

            if(bridgeGame.isMoveSuccess() && bridgeGame.isBridgeFinished()) {
                return true;
            }
            if(!bridgeGame.isMoveSuccess()) {
                return false;
            }
        }
    }

    public void playGame() throws IllegalArgumentException {
        if(!playBridgeGame() && endGameService.isGameRestart()) {
            endGameService.restartGame();
            playGame();
        }
    }
}

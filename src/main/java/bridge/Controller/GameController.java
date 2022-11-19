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
            playBridgeGame();
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

    public void playBridgeGame() throws IllegalArgumentException {
        while(true) {
            bridgeGameService.onePhaseBridgeGame();

            if(bridgeGame.isMoveSuccess() && bridgeGame.isBridgeFinished()) {
                return;
            }
            if(!bridgeGame.isMoveSuccess()) {
                if(endGameService.isGameRestart()) {
                    endGameService.restartGame();
                }else{
                    return;
                }
            }
        }
    }
}

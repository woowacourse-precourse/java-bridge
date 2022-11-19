package bridge.controller;

import bridge.domain.GameResult;
import bridge.domain.MatchResult;
import bridge.dto.BridgeDto;
import bridge.service.GameService;
import bridge.service.ViewService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final ViewService viewService;
    private final GameService gameService;

    public GameController() {
        this.viewService = new ViewService(new InputView(), new OutputView());
        this.gameService = GameService.createNewGame(viewService);
    }

    public GameController(ViewService viewService, GameService gameService) {
        this.viewService = viewService;
        this.gameService = gameService;
    }

    public void run() {
        GameResult gameResult;
        int count = 0;
        do {
            count++;
            if (doRound().equals(MatchResult.FINISH)) {
                gameResult = GameResult.SUCCESS;
                break;
            }
            gameResult = chooseReGame();
        } while (gameResult.equals(GameResult.REGAME));
        finish(gameResult, count);
    }

    private void finish(GameResult gameResult, int count) {
        BridgeDto recentBridge = gameService.getRecentBridge();
        viewService.printTotalResult(recentBridge, gameResult, count);
    }

    private MatchResult doRound() {
        MatchResult matchResult;
        do {
            matchResult = chooseMovement();
        } while (matchResult.equals(MatchResult.SUCCESS));
        return matchResult;
    }

    private MatchResult chooseMovement() {
        String movement = viewService.askMovement();
        MatchResult recentResult = gameService.moveForward(movement);

        BridgeDto dto = gameService.getRecentBridge();
        viewService.printBridge(dto);
        return recentResult;
    }

    private GameResult chooseReGame() {
        String input = viewService.askReGame();
        return gameService.setReGameOrQuit(input);
    }
}

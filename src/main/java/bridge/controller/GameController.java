package bridge.controller;

import bridge.domain.GameResult;
import bridge.domain.MatchResult;
import bridge.dto.BridgeDto;
import bridge.dto.GameResultDto;
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
        GameResultDto gameResultDto = doGame();
        finishGame(gameResultDto);
    }

    private GameResultDto doGame() {
        GameResultDto gameResultDto = new GameResultDto();
        GameResult gameResult;
        do {
            gameResultDto.counting();
            MatchResult matchResult = doRound();
            gameResult = doRetryOrQuit(matchResult);
        } while (isReGame(gameResult));
        gameResultDto.setGameResult(gameResult);
        return gameResultDto;
    }

    private GameResult doRetryOrQuit(MatchResult matchResult) {
        if (matchResult.equals(MatchResult.FINISH)) {
            return GameResult.SUCCESS;
        }
        return chooseReGame();
    }

    private boolean isReGame(GameResult result) {
        return result.equals(GameResult.REGAME);
    }

    private void finishGame(GameResultDto gameResultDto) {
        BridgeDto recentBridge = gameService.getRecentBridge();
        viewService.printTotalResult(recentBridge, gameResultDto);
    }

    private MatchResult doRound() {
        MatchResult matchResult;

        do {
            matchResult = chooseMove();
        } while (matchResult.equals(MatchResult.SUCCESS));

        return matchResult;
    }

    private MatchResult chooseMove() {
        String movement = viewService.askMove();
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

package bridge.controller;

import bridge.domain.game.SquareResult;
import bridge.dto.BridgeResultDto;
import bridge.dto.GameResultDto;
import bridge.service.GameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        try {
            init();
            playGame();
            printFinalResult();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void init() {
        outputView.printInit();
    }

    protected void playGame() {
        do {
            SquareResult squareResult = getUpToNowMoveResult();
            BridgeResultDto bridgeResultDto = gameService.getFormattedEachMoveResult(squareResult);
            outputView.printMap(bridgeResultDto);
            gameService.isEndOfBridgeExit();
            isFailRestartOrExit(squareResult);
        } while (gameService.inProgress());
    }

    private SquareResult getUpToNowMoveResult() {
        String move = inputView.readMoving();
        return gameService.moveBridge(move);
    }

    private void isFailRestartOrExit(SquareResult squareResult) {
        if (squareResult.isMoveFail()) {
            String command = inputView.readGameCommand();
            gameService.restartOrExitGame(command);
        }
    }

    protected void printFinalResult() {
        GameResultDto gameResultDto = gameService.getFinalGameResult();
        outputView.printResult(gameResultDto);
    }
}

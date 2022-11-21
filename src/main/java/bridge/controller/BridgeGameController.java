package bridge.controller;

import bridge.domain.bridge.BridgeSize;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.SquareResult;
import bridge.dto.GameResultDto;
import bridge.service.BridgeService;
import bridge.service.GameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    private final BridgeService bridgeService;

    private final GameService gameService;

    public BridgeGameController(BridgeService bridgeService, GameService gameService) {
        this.bridgeService = bridgeService;
        this.gameService = gameService;
    }

    public void run() {
        init();
        while (gameService.inProgress()) {
            SquareResult squareResult = getUpToNowMoveResult();
            outputView.printMap(gameService.getFormattedEachMoveResult(squareResult));
            gameService.isSuccessMoveBridge(squareResult);
            gameService.isEndOfBridgeExit();
            isFailRestartOrExit();
        }
        printFinalResult();
    }

    private void init() {
        outputView.printInit();

        int size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        bridgeService.createBridge(bridgeSize.get());

        gameService.initGame(new BridgeGame(), bridgeSize.get());
    }

    private SquareResult getUpToNowMoveResult() {
        String move = inputView.readMoving();
        int curPosition = gameService.getCurrentPosition();
        return bridgeService.getOneSpaceMoveResult(move, curPosition);
    }

    private void isFailRestartOrExit() {
        String command = inputView.readGameCommand();
        gameService.restartOrExitGame(command);
    }

    private void printFinalResult() {
        GameResultDto gameResultDto = gameService.getFinalGameResult();
        outputView.printResult(gameResultDto);
    }
}

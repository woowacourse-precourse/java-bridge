package bridge.controller;

import static bridge.domain.constants.GameCommands.NOTHING;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;

import bridge.domain.bridge_game.BridgeGame;
import bridge.domain.bridge_game.MoveResults;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import bridge.domain.validation.BridgeSize;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameService bridgeGameService;

    public BridgeGameController(final InputView inputView, final OutputView outputView,
            final BridgeGameService bridgeGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGameService = bridgeGameService;
    }

    public void startBridgeGame() {
        outputView.printStartMessage();

        BridgeSize bridgeSize = inputView.bridgeSize();
        BridgeGame bridgeGame = bridgeGameService.bridgeGame(bridgeSize);

        playBridgeGame(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    private void playBridgeGame(final BridgeGame bridgeGame) {
        GameCommands gameCommand = NOTHING;

        while (bridgeGame.isNotOver(gameCommand)) {
            String moveResult = moveResult(bridgeGame);

            if (moveResult.equals(MOVE_FAIL)) {
                gameCommand = inputView.gameCommand();
                bridgeGame.retryOrQuit(gameCommand);
            }
        }
    }

    private String moveResult(final BridgeGame bridgeGame) {
        MoveCommands moveCommand = inputView.moveCommand();
        String moveResult = bridgeGame.moveResult(moveCommand);

        printCurrentPosition(bridgeGame, moveCommand, moveResult);
        bridgeGame.move(moveResult);

        return moveResult;
    }

    private void printCurrentPosition(final BridgeGame bridgeGame, final MoveCommands moveCommand,
            final String moveResult) {
        MoveResults moveResults = bridgeGame.moveResults(moveCommand, moveResult);
        outputView.printMap(moveResults);
    }
}

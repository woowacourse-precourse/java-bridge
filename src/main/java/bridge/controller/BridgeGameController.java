package bridge.controller;

import bridge.constant.GameCommand;
import bridge.constant.MoveCommand;
import bridge.constant.MoveSign;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResults;
import bridge.domain.BridgeSizeValidator;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameService bridgeGameService;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGameService bridgeGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGameService = bridgeGameService;
    }

    public void startBridgeGame() {
        outputView.printStartMessage();

        BridgeSizeValidator bridgeSize = inputView.bridgeSize();
        BridgeGame bridgeGame = bridgeGameService.bridgeGame(bridgeSize);

        playBridgeGame(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    private void playBridgeGame(final BridgeGame bridgeGame) {
        GameCommand gameCommand = GameCommand.NOTHING;
        while (bridgeGame.isNotOver(gameCommand)) {
            String moveResult = moveResult(bridgeGame);
            if (moveResult.equals(MoveSign.MOVE_FAIL.getMessage())) {
                gameCommand = inputView.gameCommand();
                bridgeGame.retryOrQuit(gameCommand);
            }
        }
    }

    private String moveResult(final BridgeGame bridgeGame) {
        MoveCommand moveCommand = inputView.moveCommand();
        String moveResult = bridgeGame.bridgeGameResult(moveCommand);

        printCurrentPosition(bridgeGame, moveCommand, moveResult);
        bridgeGame.move(moveResult);

        return moveResult;
    }

    private void printCurrentPosition(BridgeGame bridgeGame, MoveCommand moveCommand, String moveResult) {
        BridgeGameResults moveResults = bridgeGame.bridgeGameResults(moveCommand, moveResult);
        outputView.printMap(moveResults);
    }
}

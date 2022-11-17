package bridge.controller;

import static bridge.domain.constants.GameCommands.QUIT_GAME_COMMAND;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResults;
import bridge.domain.Player;
import bridge.domain.make_bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView,
            BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void gameStart() {
        outputView.printStartMessage();

        int bridgeSize = inputView.bridgeSize();
        BridgeGame bridgeGame = bridgeGame(bridgeSize);

        String result = gameResult(bridgeGame, bridgeSize);
        outputView.printResult(bridgeGame.moveResults(), bridgeGame.player(), result);
    }

    private BridgeGame bridgeGame(int bridgeSize) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        Player player = new Player(0, 1);
        return new BridgeGame(bridge, player, new MoveResults());
    }

    private String gameResult(BridgeGame bridgeGame, int bridgeSize) {
        String gameCommand = "";
        String result = "성공";

        while (!gameCommand.equals(QUIT_GAME_COMMAND) && bridgeGame.ongoing(bridgeSize)) {
            String moveResult = moveResult(bridgeGame);

            if (moveResult.equals(MOVE_FAIL)) {
                gameCommand = inputView.gameCommand();
                result = bridgeGame.retryOrQuit(gameCommand, result);
            }
        }

        return result;
    }

    private String moveResult(BridgeGame bridgeGame) {
        String moveCommand = inputView.moveCommands();
        String moveResult = bridgeGame.matchResult(moveCommand);

        printCurrentPosition(bridgeGame, moveCommand, moveResult);
        bridgeGame.move(moveResult);

        return moveResult;
    }

    private void printCurrentPosition(BridgeGame bridgeGame, String moveSign, String resultSign) {
        MoveResults moveResults = bridgeGame.moveResults(moveSign, resultSign);
        outputView.printMap(moveResults);
    }
}

package bridge.controller;

import static bridge.domain.constants.GameCommands.NOTHING;
import static bridge.domain.constants.GameCommands.QUIT;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResults;
import bridge.domain.Player;
import bridge.domain.constants.GameCommands;
import bridge.domain.make_bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    public static final String GAME_SUCCESS = "성공";
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

        String gameResult = gameResult(bridgeGame, bridgeSize);
        outputView.printResult(bridgeGame, gameResult);
    }

    private BridgeGame bridgeGame(int bridgeSize) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        Player player = new Player(0, 1);

        return new BridgeGame(bridge, player, new MoveResults());
    }

    private String gameResult(BridgeGame bridgeGame, int bridgeSize) {
        GameCommands gameCommand = NOTHING;
        String gameResult = GAME_SUCCESS;

        while (gameCommand.isNot(QUIT) && bridgeGame.positionNotMoreThan(bridgeSize)) {
            String moveResult = moveResult(bridgeGame);

            if (moveResult.equals(MOVE_FAIL)) {
                gameCommand = inputView.gameCommand();
                gameResult = bridgeGame.retryOrQuit(gameCommand, gameResult);
            }
        }

        return gameResult;
    }

    private String moveResult(BridgeGame bridgeGame) {
        String moveCommand = inputView.moveCommands();
        String moveResult = bridgeGame.matchResult(moveCommand);

        printCurrentPosition(bridgeGame, moveCommand, moveResult);
        bridgeGame.move(moveResult);

        return moveResult;
    }

    private void printCurrentPosition(BridgeGame bridgeGame, String moveCommand,
            String moveResult) {
        MoveResults moveResults = bridgeGame.moveResults(moveCommand, moveResult);
        outputView.printMap(moveResults);
    }
}

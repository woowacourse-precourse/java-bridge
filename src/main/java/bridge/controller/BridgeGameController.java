package bridge.controller;

import static bridge.domain.constants.GameCommands.NOTHING;
import static bridge.domain.constants.GameCommands.QUIT;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.move_result.MoveResults;
import bridge.domain.Player;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import bridge.domain.make_bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;
    public static final String GAME_SUCCESS = "성공";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(final InputView inputView, final OutputView outputView,
            final BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void gameStart() {
        outputView.printStartMessage();

        BridgeSize bridgeSize = inputView.bridgeSize();
        BridgeGame bridgeGame = bridgeGame(bridgeSize);

        String gameResult = gameResult(bridgeGame, bridgeSize);
        outputView.printResult(bridgeGame, gameResult);
    }

    private BridgeGame bridgeGame(final BridgeSize bridgeSize) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.bridgeSize()));
        Player player = new Player(INIT_VALUE_OF_POSITION, INIT_VALUE_OF_CHALLENGES);

        return new BridgeGame(bridge, player, new MoveResults());
    }

    private String gameResult(final BridgeGame bridgeGame, final BridgeSize bridgeSize) {
        GameCommands gameCommand = NOTHING;
        String gameResult = GAME_SUCCESS;

        while (!gameCommand.is(QUIT) && bridgeGame.positionIsNotMoreThan(bridgeSize)) {
            String moveResult = moveResult(bridgeGame);

            if (moveResult.equals(MOVE_FAIL)) {
                gameCommand = inputView.gameCommand();
                gameResult = bridgeGame.retryOrQuit(gameCommand, gameResult);
            }
        }

        return gameResult;
    }

    private String moveResult(final BridgeGame bridgeGame) {
        MoveCommands moveCommand = inputView.moveCommands();
        String moveResult = bridgeGame.matchResult(moveCommand);

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

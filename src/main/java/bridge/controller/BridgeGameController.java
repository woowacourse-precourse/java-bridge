package bridge.controller;

import static bridge.domain.constants.GameCommands.NOTHING;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.validation.BridgeSize;
import bridge.domain.NumberOfChallenges;
import bridge.domain.Player;
import bridge.domain.Position;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import bridge.domain.make_bridge.BridgeMaker;
import bridge.domain.MoveResults;
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

    public void run() {
        outputView.printStartMessage();

        BridgeSize bridgeSize = inputView.bridgeSize();
        BridgeGame bridgeGame = bridgeGame(bridgeSize);

        startBridgeGame(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    private BridgeGame bridgeGame(final BridgeSize bridgeSize) {
        Bridge bridge = new Bridge(
                bridgeMaker.makeBridge(bridgeSize.bridgeSize()));

        Player player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new NumberOfChallenges(INIT_VALUE_OF_CHALLENGES));

        return new BridgeGame(bridge, player, new MoveResults());
    }

    private void startBridgeGame(final BridgeGame bridgeGame) {
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

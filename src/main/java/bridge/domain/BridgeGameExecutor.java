package bridge.domain;


import bridge.enums.RoundResult;
import bridge.enums.MoveResult;
import bridge.enums.SystemOperation;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameExecutor {

    private static final BridgeGameExecutor instance = new BridgeGameExecutor();
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private BridgeGameExecutor() {
    }

    public static BridgeGameExecutor getInstance() {
        return instance;
    }

    public void start() {
        BridgeGame bridgeGame = BridgeGame.initNewGame(inputView.readBridgeSize());

        while (startNewRound(bridgeGame) == RoundResult.FAIL) {
            if (inputView.readGameCommand() == SystemOperation.QUIT) {
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame);
    }

    private RoundResult startNewRound(BridgeGame bridgeGame) {
        while (!bridgeGame.reachOppositeSide()) {
            MoveResult moveResult = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            if (moveResult == MoveResult.NOT_ANSWER) {
                return RoundResult.FAIL;
            }
        }

        return RoundResult.SUCCESS;
    }
}

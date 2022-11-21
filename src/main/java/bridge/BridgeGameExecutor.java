package bridge;


import bridge.enums.RoundResult;
import bridge.enums.MoveResult;

public class BridgeGameExecutor {
    private static final BridgeGameExecutor instance = new BridgeGameExecutor();
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private BridgeGameExecutor() {
    }

    public static BridgeGameExecutor getInstance() {
        return instance;
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

package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.Player;
import bridge.type.RetryType;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final Player player;
    private final BridgeGame bridgeGame;

    public BridgeGameController(Player player, BridgeGame bridgeGame) {
        this.player = player;
        this.bridgeGame = bridgeGame;
    }

    public int run(int bridgeSize) {
        int start = 0;
        while (start != bridgeSize) {
            bridgeGame.start(player, InputView.readMoving());
            boolean isPass = bridgeGame.move(player, start);

            OutputView.printMap(player, isPass, start);

            RetryType retryType = bridgeGame.retry(isPass);
            start = nextStepOrReset(start, retryType);
            if (RetryType.finish(retryType)) break;
        }
        return start;
    }

    private int nextStepOrReset(int start, RetryType retryType) {
        start++;
        start = retryType.reset(player, start);
        return start;
    }
}

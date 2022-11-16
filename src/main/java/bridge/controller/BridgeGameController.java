package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResults;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    public static final String PASS_SIGN = "O";
    public static final String FAIL_SIGN = "X";

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

        String gameCommand = "";
        String success = "성공";
        while (!gameCommand.equals("Q") && bridgeGame.ongoing(bridgeSize)) {
            String moveSign = inputView.movement();
            String resultSign = bridgeGame.matchResult(moveSign);

            GameResults gameResults = bridgeGame.gameResults(moveSign, resultSign);
            outputView.printMap(gameResults);

            if (resultSign.equals(PASS_SIGN)) {
                bridgeGame.move();
            }

            if (resultSign.equals(FAIL_SIGN)) {
                gameCommand = inputView.gameCommand();
                if (gameCommand.equals("R")) {
                    bridgeGame.retry();
                    continue;
                }

                success = "실패";
            }
        }

        outputView.printResult(bridgeGame.gameResults(), bridgeGame.player(), success);
    }

    private BridgeGame bridgeGame(int bridgeSize) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        Player player = new Player(0, 1);
        return new BridgeGame(bridge, player, new GameResults());
    }
}

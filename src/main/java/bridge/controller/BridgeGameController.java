package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResults;
import bridge.domain.Player;
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

        outputView.printInputBridgeLengthMessage();
        int bridgeSize = inputView.bridgeSize();

        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        Player player = new Player(0, 1);
        BridgeGame bridgeGame = new BridgeGame(bridge, player, new GameResults());

        String gameCommand = "";
        String success = "성공";
        while (!gameCommand.equals("Q") && (player.position() != bridgeSize)) {
            outputView.printMovingMessage();
            String moveSign = inputView.movement();
            String resultSign = bridgeGame.matchResult(moveSign);

            GameResults gameResults = bridgeGame.gameResults(moveSign);
            outputView.printMap(gameResults);  // position은 출력 후 올려야..

            if (resultSign.equals("O")) {
                bridgeGame.move();
            }

            if (resultSign.equals("X")) {
                outputView.printGameCommandMessage();
                gameCommand = inputView.gameCommand();
                if (gameCommand.equals("R")) {
                    bridgeGame.retry();
                    continue;
                }

                success = "실패";
            }
        }

        outputView.printResult(bridgeGame.gameResults(), player, success);
    }
}

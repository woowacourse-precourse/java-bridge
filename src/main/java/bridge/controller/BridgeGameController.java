package bridge.controller;

import static bridge.domain.constants.GameCommands.QUIT_GAME_COMMAND;
import static bridge.domain.constants.GameCommands.RESTART_GAME_COMMAND;
import static bridge.domain.constants.ResultSigns.FAIL_SIGN;
import static bridge.domain.constants.ResultSigns.PASS_SIGN;

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
        int bridgeSize = inputView.bridgeSize();
        BridgeGame bridgeGame = bridgeGame(bridgeSize);

        String gameCommand = "";
        String success = "성공";
        while (!gameCommand.equals(QUIT_GAME_COMMAND) && bridgeGame.ongoing(bridgeSize)) {
            String moveSign = inputView.moveCommands();
            String resultSign = bridgeGame.matchResult(moveSign);

            GameResults gameResults = bridgeGame.gameResults(moveSign, resultSign);
            outputView.printMap(gameResults);

            if (resultSign.equals(PASS_SIGN)) {
                bridgeGame.move();
            }

            if (resultSign.equals(FAIL_SIGN)) {
                gameCommand = inputView.gameCommand();
                if (gameCommand.equals(RESTART_GAME_COMMAND)) {
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

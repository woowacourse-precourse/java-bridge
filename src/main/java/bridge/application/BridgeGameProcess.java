package bridge.application;

import bridge.BridgeRandomNumberGenerator;
import bridge.common.message.ConsoleOut;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.InputView;
import bridge.domain.OutputView;
import bridge.domain.ProcessHelper;
import bridge.domain.vo.MatchResult;
import bridge.infrastructure.ProcessHelperImpl;
import java.util.List;

public class BridgeGameProcess {

    private static ProcessHelper processHelper = new ProcessHelperImpl();
    private static InputView inputView = new InputView();

    public static void run() {
        ConsoleOut.GAME_START_MESSAGE.print();
        int bridgeSize = inputView.readBridgeSize(processHelper);
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(
            bridgeSize);
        repeatTheGame(bridgeSize, bridge);
    }

    private static void repeatTheGame(int bridgeSize, List<String> bridge) {
        while (true) {
            BridgeGame bridgeGame = new BridgeGame();
            MatchResult matchResult = new MatchResult();
            OutputView outputView = new OutputView();
            moveOrNot(bridgeSize, bridge, bridgeGame, matchResult, outputView);
            if (isWinningGame(bridge, bridgeGame, matchResult, outputView)) {
                break;
            }
            String gameCommand = inputView.readGameCommand(processHelper);
            if (isRetry(bridgeGame, matchResult, outputView, gameCommand)) {
                break;
            }

        }
    }

    private static boolean isRetry(BridgeGame bridgeGame, MatchResult matchResult,
        OutputView outputView, String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry(matchResult);
        }
        if (gameCommand.equals("Q")) {
            outputView.printResult(matchResult);
            bridgeGame.looseGame();
            return true;
        }
        return false;
    }

    private static boolean isWinningGame(List<String> bridge, BridgeGame bridgeGame,
        MatchResult matchResult, OutputView outputView) {
        if (bridge.equals(bridgeGame.currentUserInput())) {
            outputView.printResult(matchResult);
            bridgeGame.winningGame();
            return true;
        }
        return false;
    }

    private static void moveOrNot(int bridgeSize, List<String> bridge, BridgeGame bridgeGame,
        MatchResult matchResult, OutputView outputView) {
        for (int index = 0; index < bridgeSize; index++) {

            String moving = inputView.readMoving(processHelper); // u or d 입력

            if (!bridgeGame.move(bridge, moving, index)) {
                outputView.printMap(matchResult, bridgeGame.currentUserInput(), false);
                break;
            }
            outputView.printMap(matchResult, bridgeGame.currentUserInput(), true);
        }
    }
}

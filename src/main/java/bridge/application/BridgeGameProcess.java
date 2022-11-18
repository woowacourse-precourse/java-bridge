package bridge.application;

import bridge.BridgeRandomNumberGenerator;
import bridge.common.message.ConsoleOut;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.InputView;
import bridge.domain.OutputView;
import bridge.domain.ProcessHelper;
import bridge.domain.vo.MatchResult;
import bridge.infra.ProcessHelperImpl;
import java.util.List;

public class BridgeGameProcess {

    private static ProcessHelper processHelper = new ProcessHelperImpl();
    private static InputView inputView = new InputView();

    public static void run() {
        ConsoleOut.GAME_START_MESSAGE.print();
        int bridgeSize = inputView.readBridgeSize(processHelper);
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        System.out.println(bridge); // 게임 보드 브릿지 생성
        while (true) {
            BridgeGame bridgeGame = new BridgeGame();
            MatchResult matchResult = new MatchResult();
            OutputView outputView = new OutputView();
            for (int index = 0; index < bridgeSize; index++) {

                String moving = inputView.readMoving(processHelper);

                if (bridgeGame.move(bridge, moving, index)) {
                    outputView.printMap(matchResult);
                }
                if (!bridgeGame.move(bridge, moving, index)) {
                    outputView.printMap(matchResult);
                    break;
                }
            }
            if (bridge.equals(bridgeGame.currentUserInput())) {
                outputView.printResult(matchResult);
                bridgeGame.winningGame();
                break;
            }
            if (inputView.readGameCommand(processHelper) == "R") {
                bridgeGame.retry(matchResult);
            }
            if (inputView.readGameCommand(processHelper) == "Q") {
                outputView.printResult(matchResult);
                bridgeGame.looseGame();
                break;
            }

        }
    }
}

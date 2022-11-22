package bridge;

import bridge.domain.BridgeGame;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.ui.InputTry.*;

public class BridgeGameRun {
    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_FAILURE = "실패";
    private static final OutputView output = new OutputView();
    private static final BridgeGame game = new BridgeGame();

    private List<String> bridge = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private int gameTryCount = 0;

    public void runBridgeGame() {
        setBridge();

        String judge;
        do {
            oneRound();
            judge = game.judgeSuccessFailure(bridge, path);

        } while (judge.equals(GAME_FAILURE) && game.retry(readGameCommandTry()));

        output.printResult(judge, gameTryCount);
    }

    private void setBridge() {
        System.out.println(START_BRIDGE_GAME);

        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int bridgeSize = readBridgeSizeTry();
        bridge = maker.makeBridge(bridgeSize);
    }

    private void oneRound() {
        gameTryCount++;
        path.clear();

        do {
            path.add(readMovingTry());
            output.printMap(bridge, path);

        } while (game.move(bridge, path));
    }

}

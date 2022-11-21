package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameRun {
    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_FAILURE = "실패";
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static final BridgeGame game = new BridgeGame();

    private List<String> bridge = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private int gameTryCount = 0;

    public void runBridgeGame() {
        beginningPart();

        String judge;
        do {
            oneRound();
            judge = game.judgeSuccessFailure(bridge, path);

        } while (judge.equals(GAME_FAILURE) && game.retry(input.readGameCommand()));

        output.printResult(judge, gameTryCount);
    }

    private void beginningPart() {
        System.out.println(START_BRIDGE_GAME);

        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int bridgeSize = input.readBridgeSize();
        bridge = maker.makeBridge(bridgeSize);
    }

    private void oneRound() {
        gameTryCount++;
        path.clear();

        do {
            path.add(input.readMoving());
            output.printMap(bridge, path);

        } while (game.move(bridge, path));
    }

}

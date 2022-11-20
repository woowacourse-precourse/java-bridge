package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameRun {
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static final BridgeGame game = new BridgeGame();

    private List<String> bridge = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private int gameTryCount = 0;

    public void runBridgeGame() {

        beginningPart();

        String gameRetryCommand;
        String judge = "실패";

        do {
            oneRound();

            if (game.judgeSuccessFailure(bridge, path)) {
                judge = "성공";
                break;
            }
            gameRetryCommand = input.readGameCommand();
        } while (game.retry(gameRetryCommand));

        output.printResult(judge, gameTryCount);
    }

    private void beginningPart() {
        System.out.println("다리 건너기 게임을 시작합니다.");

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

package bridge;

import java.util.List;

public class BridgeGameController {
    public static final String START = "다리 건너기 게임을 시작합니다.";
    public static final String RETRY = "R";
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        printStartMessage();

        List<String> bridge = makeBridge();

        BridgeGame bridgeGame = new BridgeGame(bridge);
        run(bridgeGame);

        outputView.printResult(bridgeGame);
    }

    private static void printStartMessage() {
        System.out.println(START);
        System.out.println();
    }

    private List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }


    private void run(BridgeGame bridgeGame) {
        while (bridgeGame.isNormal()) {
            move(bridgeGame);
        }

        if (bridgeGame.isGameOver()) {
            RetryOrQuit(bridgeGame);
        }
    }

    private void move(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        outputView.printMap(bridgeGame);
    }

    private void RetryOrQuit(BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(RETRY)) {
            bridgeGame.retry();
            run(bridgeGame);
        }
    }
}

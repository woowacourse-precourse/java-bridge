package bridge;

import java.util.List;
import java.util.function.Supplier;

public class BridgeGameController {
    public static final String START = "다리 건너기 게임을 시작합니다.";
    public static final String RETRY = "R";
    public static final String ERROR_PREFIX = "[ERROR] ";
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
        Integer bridgeSize = handleException(inputView::readBridgeSize);
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
        String moving = handleException(inputView::readMoving);
        bridgeGame.move(moving);
        outputView.printMap(bridgeGame);
    }

    private void RetryOrQuit(BridgeGame bridgeGame) {
        String gameCommand = handleException(inputView::readGameCommand);
        if (gameCommand.equals(RETRY)) {
            bridgeGame.retry();
            run(bridgeGame);
        }
    }

    private <T> T handleException(Supplier<T> readSomething) {
        T input;
        try {
            input = readSomething.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            input = handleException(readSomething);
        }
        return input;
    }
}

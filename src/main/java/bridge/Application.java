package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static Repository repository = new Repository();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();
        start();
        do {
            repository.setTimes(repository.getTimes() + 1);
            bridgeGame.newGame();
            playing();
        } while (retryQuit());
        outputView.printResult(repository.getResult(), repository.getTimes());
    }

    private static boolean retryQuit() {
        if (endGame()) return false;
        try {
            outputView.printGame();
            return bridgeGame.retry(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            retryQuit();
        }
        return true;
    }

    private static boolean endGame() {
        repository.save(bridgeGame.getGame());
        if (bridgeGame.success()) {
            return true;
        }
        return false;
    }

    private static void playing() {
        String match;
        try {
            moving();
        } catch (IllegalArgumentException e) {
            playing();
            outputView.printError(e.getMessage());
        }
    }

    private static void moving() {
        String match;
        do {
            outputView.printMove();
            match = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getGame());
        } while (bridgeGame.wrong(match));
    }

    private static void start() {
        try {
            outputView.printBridgeSize();
            int size = inputView.readBridgeSize();
            bridgeGame.createBridge(size);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            start();
        }
    }
}

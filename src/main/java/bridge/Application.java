package bridge;
import bridge.InputView;

public class Application {
    private final static OutputView outPutView = new OutputView();
    private final static InputView inPutView = new InputView();
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static Repository repository = new Repository();
    public static void main(String[] args) {
        outPutView.printStart();
        run();
        do {
            repository.setTimes(repository.getTimes() + 1);
            bridgeGame.newGame();
            playing();
        } while(retryQuit());
        outPutView.printResult(repository.getResult(), repository.getTimes());
    }

    private static void run() {
        try {
            outPutView.printSize();
            int size = inPutView.readBridgeSize();
            bridgeGame.createBridge(size);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            run();
        }
    }

    private static void running() {
        String checkOX;
        do {
            outPutView.moveUpDown();
            checkOX = bridgeGame.move(inPutView.readMoving());
            outPutView.printMap(bridgeGame.getGame());
        } while (bridgeGame.check(checkOX));
    }

    private static void playing() {
        try {
            running();
        } catch (IllegalArgumentException e) {
            playing();
            System.out.println("[ERROR]");
        }
    }

    private static boolean retryQuit() {
        if (endGame()) return false;
        try {
            outPutView.printGame();
            return bridgeGame.retry(inPutView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
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

}

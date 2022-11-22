package bridge;

public class Application {

    private static final InputView inputView = new InputView();
    private static BridgeGame bridgeGame;
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            int size = initGame();
            gameStart(size);
            outputView.printResult(bridgeGame.getUpBridgeToString(),
                bridgeGame.getDownBridgeToString(), bridgeGame.isClear(),
                bridgeGame.getCountOfTry());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        int size = inputView.readBridgeSize();
        System.out.println();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));

        return size;
    }

    private static void gameStart(int size) {
        while (true) {
            if (!gameOver(size)) {
                break;
            }
        }
    }

    private static boolean gameOver(int size) {
        loop(size);

        if (!bridgeGame.isClear()) {
            if (inputView.readGameCommand().equals("R")) {
                bridgeGame.retry();
                return true;
            }
            return false;
        }
        return false;
    }

    private static void loop(int size) {
        for (int i = 0; i < size; i++) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getUpBridgeToString(),
                bridgeGame.getDownBridgeToString());

            if (!bridgeGame.isClear()) {
                break;
            }
        }
    }
}

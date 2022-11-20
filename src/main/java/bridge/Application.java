package bridge;


public class Application {

    public final static String ERROR_PREFIX = "[ERROR] ";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            BridgeGame bridgeGame = createNewGame();
            game(bridgeGame);
            outputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void game(BridgeGame bridgeGame) {
        while (!bridgeGame.isComplete()) {
            boolean moveSuccess = move(bridgeGame);
            if (moveSuccess) {
                continue;
            }
            if (inputView.readGameCommand().equals("Q")) {
                break;
            }
            bridgeGame.retry();
        }
    }

    private static boolean move(BridgeGame bridgeGame) {
        String moveDirection = inputView.readMoving();
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getCurrentIdx(), DIRECTION.toEnum(moveDirection));
        return bridgeGame.move(moveDirection);
    }

    private static BridgeGame createNewGame() {
        return new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(inputView.readBridgeSize()));
    }
}

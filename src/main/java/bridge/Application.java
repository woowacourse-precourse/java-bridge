package bridge;

public class Application {

    public final static String ERROR_PREFIX = "[ERROR] ";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            BridgeGame bridgeGame = createNewGame();
            while (true) {
                boolean success = move(bridgeGame);
                if (bridgeGame.isComplete()) {
                    break;
                }
                if (!success) {
                    // TODO: 게임 재시도 혹은 종료 여부 받기
                    break;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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

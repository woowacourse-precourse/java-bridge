package bridge;

public class Application {

    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(
        new BridgeRandomNumberGenerator()
    );

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다");
        BridgeGame game = makeGame();
        String moving = inputView.readMoving();
    }

    private static BridgeGame makeGame() {
        while (true) {
            try {
                int size = inputView.readBridgeSize();
                return new BridgeGame(bridgeMaker.makeBridge(size));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 크기는 3이상 20이하이어야 합니다.");
            }
        }
    }
}

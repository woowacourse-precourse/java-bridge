package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();

        System.out.println("다리 건너기 게임을 시작합니다.");
        try {

            int size = inputView.readBridgeSize();
            bridgeGame.run(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

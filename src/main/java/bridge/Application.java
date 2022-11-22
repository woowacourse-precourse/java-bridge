package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        int size;

        size = inputView.readBridgeSize();
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeGame.run(size);
    }
}

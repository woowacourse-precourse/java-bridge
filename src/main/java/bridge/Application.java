package bridge;

public class Application {
    final static InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        int size;

        try{
            size = inputView.readBridgeSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // TODO: 프로그램 구현
    }
}

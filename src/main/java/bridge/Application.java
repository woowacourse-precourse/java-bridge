package bridge;

public class Application {
    /**
     * 게임을 시작하는 메서드
     */
    static void gameStart() {
        OutputView outputView = new OutputView();

        outputView.printStart();
    }

    /**
     * 다리 길이를 물어볼 때 사용하는 메서드
     */
    static void knowBridgeLength() {
        OutputView outputView = new OutputView();
        InputView inputview = new InputView();

        outputView.printBridgeLength();
        int bridgeSize = inputview.readBridgeSize();
    }

    public static void main(String[] args) {
        Application.gameStart();
        Application.knowBridgeLength();
    }
}

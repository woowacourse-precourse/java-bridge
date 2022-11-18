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
    static int knowBridgeLength() {
        OutputView outputView = new OutputView();
        InputView inputview = new InputView();
        BridgeGame bridgegame = new BridgeGame();

        outputView.printBridgeLength();
        String readBridgeSize = inputview.readBridgeSize();
        int checkBridgeType = bridgegame.checkBridgeType(readBridgeSize);

        return checkBridgeType;
    }

    public static void main(String[] args) {
        try {
            Application.gameStart();
            int BridgeSize = Application.knowBridgeLength();
        } catch (IllegalArgumentException e) {}
    }
}

package bridge;

public class Application {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printMessage(GAME_START);
        while (getBridgeSize() == 0) {
            getBridgeSize();
        }

    }

    public static int getBridgeSize() {
        InputView inputView = new InputView();
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return 0;
        }
    }
}

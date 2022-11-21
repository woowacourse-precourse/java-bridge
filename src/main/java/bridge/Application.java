package bridge;

public class Application {

    private static final String BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(BRIDGE_GAME_START_MESSAGE);
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
    }
}

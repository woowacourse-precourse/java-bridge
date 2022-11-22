package bridge.output;

public class BridgeGameStarter {
    private static final String TEXT_GAME_START = "다리 건너기 게임을 시작합니다.";

    public void atGameStart() {
        printGameStart();
    }

    private void printGameStart() {
        System.out.println(TEXT_GAME_START);
    }
}

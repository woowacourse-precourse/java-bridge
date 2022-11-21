package bridge;

public class Application {

    static final String START_GAME = "다리 건너기 게임을 시작합니다. \n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_GAME);
        InputView.readBridgeSize();
    }
}

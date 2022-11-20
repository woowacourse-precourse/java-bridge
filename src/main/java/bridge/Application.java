package bridge;

public class Application {
    private static final String START_BRIDGE_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        System.out.println(START_BRIDGE_GAME_MESSAGE);
        controller.start();

    }
}

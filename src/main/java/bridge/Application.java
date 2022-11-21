package bridge;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeGameController gameController = new BridgeGameController();
        try {
            gameController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

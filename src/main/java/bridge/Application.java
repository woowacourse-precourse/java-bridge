package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();
        controller.gameStart();
        boolean isGameContinued = true;
        while (isGameContinued) {
            controller.gameRun();
            isGameContinued = controller.isGameContinue();
        }
        controller.gameEnd();
    }
}

package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController controller = new BridgeGameController();
            controller.run();
        } catch (Exception exception) {
            // 예측 못한 에러 발생 시 메세지 출력 후 프로그램 종료
            OutputView.printUnExpectedErrorMessage(exception);
        }
    }
}

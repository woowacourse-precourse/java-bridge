package bridge;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController =
                new GameController(new InputView(), new OutputView(), new BridgeGame());
        try {
            gameController.start();
        } catch (RuntimeException exception) {
            System.out.println("[ERROR] 잘못된 함수 사용입니다. 호출 위치가 잘못되었습니다.");
        }
    }
}

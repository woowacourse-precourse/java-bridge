package bridge.view;

import bridge.config.Injector;
import bridge.constant.ViewStatus;
import bridge.dto.GameResult;

/**
 * InputView와 OutputView를 결합시킨 view이다.
 * 실제 유저와 상호작용하는 클래스
 */
public class GameView {

    private final InputView inputView;
    private final OutputView outputView;

    private ViewStatus status = ViewStatus.DETERMINE_BRIDGE_SIZE;

    public GameView(OutputView outputView) {
        inputView = Injector.getInputView();
        this.outputView = outputView;
    }

    public void makeBridge() {
        while (status == ViewStatus.DETERMINE_BRIDGE_SIZE) {
            status = inputView.makeBridge();
        }
    }

    public void move() {
        while (status != ViewStatus.WIN && status != ViewStatus.DETERMINE_CONTINUE) {
            GameResult gameResult = inputView.move();
            status = gameResult.getNextViewStatus();
        }
    }
}

package bridge;

public class Controller {
    private final InputView iView;
    private final OutputView oView;

    private final BridgeGame bridge;

    public Controller(InputView iView, OutputView oView, BridgeGame bridge) {
        this.iView  = iView;
        this.oView  = oView;
        this.bridge = bridge;
    }


}

package bridge;

import bridge.controller.BridgeController;
import bridge.view.DefaultView;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;

public class ContextFactory {

    private static ContextFactory instance;

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeController controller;
    private final View view;

    public static ContextFactory getInstance() {
        if (instance == null) {
            instance = new ContextFactory();
        }

        return instance;
    }

    private ContextFactory() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.controller = new BridgeController();
        view = new DefaultView(
                this.outputView,
                this.inputView,
                this.controller
        );
    }

    public View getView() {
        return this.view;
    }
}

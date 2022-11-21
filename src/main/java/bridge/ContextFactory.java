package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGameService;
import bridge.service.DefaultBridgeGameService;
import bridge.view.DefaultView;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;

public class ContextFactory {

    private static ContextFactory instance;

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeNumberGenerator generator;
    private final BridgeGameService service;
    private final BridgeGameController controller;
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
        this.generator = new BridgeRandomNumberGenerator();
        this.service = new DefaultBridgeGameService();
        this.controller = new BridgeGameController(generator, service);
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

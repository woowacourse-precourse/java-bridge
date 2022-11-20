package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        SettingController settingController = new SettingController();
        settingController.setBridgeGame();

    }

}

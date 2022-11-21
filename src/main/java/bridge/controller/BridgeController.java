package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.OutputView;

public class BridgeController {
    private final OutputView outputView;
    public BridgeController() {
        outputView = new OutputView();
    }

    public void run() {
        try {
            runControllers();
        } catch (Exception e) {
            e.printStackTrace();
            outputView.printException(e.getMessage());
        }
    }

    private void runControllers() {
        SettingController settingController = new SettingController();
        BridgeGame bridgeGame = settingController.setBridgeGame();
        PlayingController playingController = new PlayingController(bridgeGame);
        playingController.play();
        playingController.printResult();
    }
}

package bridge.controller;

import bridge.domain.BridgeGame;

public class BridgeController {

    public BridgeController() {
    }

    public void run() {
        SettingController settingController = new SettingController();
        BridgeGame bridgeGame = settingController.setBridgeGame();
        PlayingController playingController = new PlayingController(bridgeGame);
        playingController.play();

    }

}

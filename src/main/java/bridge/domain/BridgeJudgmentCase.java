package bridge.domain;

import bridge.controller.BridgeController;

public class BridgeJudgmentCase {
    static BridgeController bridgeController = new BridgeController();

    public static void BridgeJudgmentCaseReturn() {
        if(bridgeController.playerStatus()) {

            System.out.println("O");
            return;
        }
        if(!bridgeController.playerStatus()) {
            System.out.println("X");
        }

    }
}

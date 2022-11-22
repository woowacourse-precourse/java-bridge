package bridge.Controller;

import bridge.Service.BridgeGameService;
import bridge.Utils.GameStatus;

public class BridgeGameController {

    private BridgeGameService bridgeGameService = new BridgeGameService();

    public void playGame() {
        bridgeGameService.intialSetting();
        bridgeGameService.makeBridge();
        while (bridgeGameService.getGameStatus() == GameStatus.PROGRESS) {
            if (bridgeGameService.moveBridge() == GameStatus.SUCCESS) break;
            bridgeGameService.askReplay();
        }
        bridgeGameService.showFinalResult();
    }
}

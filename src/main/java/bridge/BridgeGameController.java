package bridge;

public class BridgeGameController {

    BridgeGameService bridgeGameService = new BridgeGameService();

    public void playGame() {
        bridgeGameService.intialSetting();
        bridgeGameService.makeBridge();
        while (bridgeGameService.getGameStatus() == GameStatus.PROGRESS) {
            if (bridgeGameService.moveBridge() == GameStatus.SUCCESS) break;
        }
    }
}

package bridge;

public class BridgeGameController {

    BridgeGameService bridgeGameService = new BridgeGameService();
    public void playGame(){
        bridgeGameService.intialSetting();
        bridgeGameService.makeBridge();
    }
}

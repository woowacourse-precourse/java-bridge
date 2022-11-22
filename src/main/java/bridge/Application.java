package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeInit bridgeInit = new BridgeInit(new InputView(new ValidException()),
                new BridgeMaker(new BridgeRandomNumberGenerator()));
        BridgeGame bridgeGame = new BridgeGame(bridgeInit, new BridgePainting());
        BridgeService bridgeService = new BridgeService(new OutputView(), bridgeGame);

        bridgeGame.gameInit();
        bridgeService.start();
    }
}

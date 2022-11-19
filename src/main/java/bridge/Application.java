package bridge;

import java.util.List;

public class Application {

    private static InputView inputView;
    private static BridgeGame bridgeGame;
    private static BridgeMaker bridgeMaker;
    private static OutputView outputView;

    public static void main(String[] args) {
        init();

    }

    private static void init(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator());

        bridgeGame.setTryCnt(1);
        outputView.printInit();
        int size = inputView.readBridgeSize();
        bridgeGame.setBridge(bridgeMaker.makeBridge(size));

        String command = inputView.readGameCommand();
    }
}

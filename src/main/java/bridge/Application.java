package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            run();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


    public static void run(){
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        outputView.printGameStart();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame.game(bridge);
        bridgeGame.finalResult(bridge);
    }
}

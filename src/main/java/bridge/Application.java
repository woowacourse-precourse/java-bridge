package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try{
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            BridgeGame game = new BridgeGame();

            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

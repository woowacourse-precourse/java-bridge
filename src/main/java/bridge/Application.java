package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void appBridgeGame(){
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        for(int idx = 0; idx < size; idx++){
            String inputValue = inputView.readMoving();
            List<String> stepResult = new ArrayList<>();
            stepResult.add(inputValue);
            outputView.printMap(stepResult, bridge);
            break;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        List<String> stepResult = new ArrayList<>();
        for(int idx = 0; idx < size; idx++){
            String inputValue = inputView.readMoving();
            stepResult.add(inputValue);
            outputView.printMap(stepResult, bridge);
        }
    }
}

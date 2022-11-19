package bridge;

import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class Application {
    private static final OutputView output = new OutputView();
    private static final InputView input = new InputView(output) ;
    public static void main(String[] args) {
        output.printStartMessage();
        List<String> bridge = getBridge();
        BridgeGame bridgeGame = new BridgeGame(output, input, bridge);
        bridgeGame.run();
    }

    static List<String> getBridge(){
        int bridgeSize;
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

        do{
            bridgeSize = input.readBridgeSize();
        }while (bridgeSize == -1);
        return bridgeMaker.makeBridge(bridgeSize);
    }
}

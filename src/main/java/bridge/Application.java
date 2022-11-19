package bridge;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.gameStart();
        int size = inputView.readBridgeSize();
        List<String> brigeResult = bridgeMaker.makeBridge(size);
        System.out.println(brigeResult);
    }
}

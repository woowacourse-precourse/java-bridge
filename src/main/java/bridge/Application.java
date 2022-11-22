package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView SizeInputView = new InputView();
        int size = SizeInputView.readBridgeSize();
        ManageGameSettings(size);
    }

    public static void ManageGameSettings(int size) {
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> Bridge = bridgeMaker.makeBridge(size);
        int tryNum = ManageGame(Bridge,outputView);
        outputView.printResult(tryNum, output);
    }

}


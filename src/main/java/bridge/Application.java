package bridge;

import bridge.domain.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize == -1) { return; }
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView(bridgeGame);
        bridgeGame.proceed(inputView, outputView);
        outputView.printResult();
    }
}

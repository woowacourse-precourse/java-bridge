package bridge;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
        makeBridge();
    }

    public static void gameStart() {
        OutputView.printGameStartPhrase();
        OutputView.printBridgeLengthInputPhrase();
    }

    public static void makeBridge() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeMaker.makeBridge(InputView.readBridgeSize());
    }
}

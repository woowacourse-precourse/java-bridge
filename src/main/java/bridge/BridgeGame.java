package bridge;

import bridge.InputView;
import bridge.OutputView;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public int determineBridgeSize() {
        outputView.printBridgeLengthInputRequest();
        return inputView.readBridgeSize();
    }

    public int move(List<String> crossable) {
        int howManyAttempts;
        howManyAttempts = bridgeMaker.makeMap(crossable);
        return howManyAttempts;
    }

    public boolean retry() {
        String continueOrEnd;
        outputView.printContinueOrEndRequest();
        continueOrEnd = inputView.readGameCommand();
        if (continueOrEnd.equals("R")) {
            return true;
        }
        return false;
    }

    public boolean play() {
        int limitSize;
        int currentSize;

        limitSize = determineBridgeSize();
        currentSize = move(bridgeMaker.makeBridge(limitSize));
        outputView.printResult(currentSize!=-1,currentSize);

        if (currentSize==-1) {
            return retry();
        }
        return false;
    }
}

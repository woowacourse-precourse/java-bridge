package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;

import java.util.List;

public class Bridge {

    private BridgeMaker bridgeMaker;
    private static int bridgeSize;
    private static List<String> bridgeAnswer;

    public Bridge() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeSize = InputView.readBridgeSize();
        this.bridgeAnswer = bridgeMaker.makeBridge(this.bridgeSize);
    }

    public static int getBridgeSize(){
        return bridgeSize;
    }

    public static List<String> getBridgeAnswer(){
        return bridgeAnswer;
    }


}

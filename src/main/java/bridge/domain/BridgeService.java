package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.bridgemaker.BridgeMaker;
import bridge.gamebridge.BridgeContainer;
import bridge.option.Move;
import bridge.result.Result;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker;
    private final BridgeContainer bridgeContainer;

    public BridgeService(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridgeContainer = new BridgeContainer();
    }

    public void generateBridge(int size) {
        List<String> squares = bridgeMaker.makeBridge(size);
        bridgeContainer.generateAnswerBridge(new Bridge(squares));
    }

    public Result insertMove(Move move) {
        return bridgeContainer.insertMove(move);
    }

    public void clearPlayerBridge() {
        bridgeContainer.clearPlayerBridge();
    }
}

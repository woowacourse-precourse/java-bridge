package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeMaker;
import bridge.command.Size;
import bridge.gamebridge.BridgeContainer;
import bridge.command.Move;
import bridge.result.Result;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker;
    private final BridgeContainer bridgeContainer;

    public BridgeService(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridgeContainer = new BridgeContainer();
    }

    public void generateBridge(Size size) {
        List<String> squares = bridgeMaker.makeBridge(size.getSize());
        bridgeContainer.generateAnswerBridge(new Bridge(squares));
    }

    public Result insertMove(Move move) {
        return bridgeContainer.insertMove(move);
    }

    public void clearPlayerBridge() {
        bridgeContainer.clearPlayerBridge();
    }
}

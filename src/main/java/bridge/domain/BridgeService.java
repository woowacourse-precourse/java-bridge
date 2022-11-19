package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.bridgemaker.BridgeMaker;
import bridge.gamebridge.GameBridge;
import bridge.option.Move;
import bridge.result.Result;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker;
    private final GameBridge gameBridge;

    public BridgeService(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.gameBridge = new GameBridge();
    }

    public void generateBridge(int size) {
        List<String> squares = bridgeMaker.makeBridge(size);
        gameBridge.generateAnswerBridge(new Bridge(squares));
    }

    public Result insertMove(Move move) {
        return gameBridge.insertMove(move);
    }

    public void clearPlayerBridge() {
        gameBridge.clearPlayerBridge();
    }
}

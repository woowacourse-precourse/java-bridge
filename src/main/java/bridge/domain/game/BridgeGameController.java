package bridge.domain.game;

import bridge.BridgeMove;
import bridge.InputView;
import bridge.domain.bridge.Bridge;
import java.util.List;

public class BridgeGameController {
    
    private final InputView inputView;
    private final BridgeGameService bridgeGameService;
    
    public BridgeGameController(List<String> bridge, InputView inputView) {
        bridgeGameService = new BridgeGameService(new BridgeGame(new Bridge(bridge)));
        this.inputView = inputView;
    }
    
    public void start() {
        BridgeMove selectMove = inputView.readMoving();
        boolean isSuccess = bridgeGameService.tryMove(selectMove);
    
        if (bridgeGameService.isFinish()) {
            return;
        }
        
        next(isSuccess);
    }
    
    private void next(boolean isSuccess) {
        if (isSuccess) {
            start();
            return;
        }
        
        if (isRetry()) {
            bridgeGameService.retry();
            start();
        }
    }
    
    private boolean isRetry() {
        return inputView.readGameCommand().equals(BridgeGameCommand.RETRY);
    }
}

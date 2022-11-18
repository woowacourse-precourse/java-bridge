package bridge.domain.game;

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
        while (!bridgeGameService.isFinish()) {
            if (!tryMoveByInput()) {
                fail();
                return;
            };
        }
    }
    
    private boolean tryMoveByInput() {
        return bridgeGameService.tryMove(inputView.readMoving());
    }
    
    private void fail() {
        handleGameCommand(inputView.readGameCommand());
    }
    
    private void handleGameCommand(BridgeGameCommand command) {
        if (command.equals(BridgeGameCommand.RETRY)) {
            bridgeGameService.retry();
            start();
        }
    }
    
}

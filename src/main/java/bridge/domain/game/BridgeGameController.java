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
        
        if (!isSuccess || bridgeGameService.isFinish()) {
            fail();
            return;
        }
        start();
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

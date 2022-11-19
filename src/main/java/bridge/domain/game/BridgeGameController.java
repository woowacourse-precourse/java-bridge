package bridge.domain.game;

import bridge.BridgeMove;
import bridge.InputView;
import bridge.domain.bridge.Bridge;
import java.util.List;

public class BridgeGameController {
    
    private final InputView inputView;
    private final BridgeGameService bridgeGameService;
    private final BridgeGame bridgeGame;
    
    public BridgeGameController(List<String> bridge, InputView inputView) {
        this.bridgeGame = new BridgeGame(new Bridge(bridge));
        bridgeGameService = new BridgeGameService(bridgeGame);
        this.inputView = inputView;
    }
    
    public void start() {
        while (!bridgeGameService.isFinish()) {
            BridgeMove selectMove = inputView.readMoving();
            boolean isSuccess = bridgeGameService.tryMove(selectMove);
            
            if (!isSuccess) {
                handleFail(selectMove);
                return;
            }
            
        }
    }
    
    private void handleFail(BridgeMove selectMove) {
        bridgeGame.fail(selectMove);
        handleGameCommand(inputView.readGameCommand());
    }
    
    private void handleGameCommand(BridgeGameCommand command) {
        if (command.equals(BridgeGameCommand.RETRY)) {
            bridgeGameService.retry();
            start();
        }
    }
    
}

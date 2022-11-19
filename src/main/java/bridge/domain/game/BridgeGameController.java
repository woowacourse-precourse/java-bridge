package bridge.domain.game;

import bridge.BridgeMove;
import bridge.InputView;
import bridge.OutputView;
import bridge.domain.bridge.Bridge;
import java.util.List;

public class BridgeGameController {
    
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameService bridgeGameService;
    
    public BridgeGameController(List<String> bridge, InputView inputView) {
        bridgeGameService = new BridgeGameService(new BridgeGame(new Bridge(bridge)));
        this.inputView = inputView;
        this.outputView = new OutputView();
    }
    
    public void start() {
        outputView.printStartMessage();
        play();
    }
    
    private void play() {
        BridgeMove selectMove = inputView.readMoving();
        boolean isSuccess = bridgeGameService.tryMove(selectMove);
        outputView.printMap(bridgeGameService.getGame());
    
        if (bridgeGameService.isFinish()) {
            return;
        }
    
        next(isSuccess);
    }
    
    private void next(boolean isSuccess) {
        if (isSuccess) {
            play();
            return;
        }
        
        if (isRetry()) {
            bridgeGameService.retry();
            play();
        }
    }
    
    private boolean isRetry() {
        return inputView.readGameCommand().equals(BridgeGameCommand.RETRY);
    }
}

package bridge.domain.game;

import bridge.BridgeMaker;
import bridge.domain.bridge.BridgeMove;
import bridge.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.domain.bridge.Bridge;

public class BridgeGameController {
    
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGameService bridgeGameService;
    
    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    
    public void start(BridgeNumberGenerator bridgeNumberGenerator) {
        outputView.printStartMessage();
        bridgeGameService = new BridgeGameService(new BridgeGame(generateBridge(bridgeNumberGenerator)));
        play();
        outputView.printResult(bridgeGameService.getGame());
    }
    
    private Bridge generateBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        return new Bridge(new BridgeMaker(bridgeNumberGenerator).makeBridge(inputView.readBridgeSize()));
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

package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.dto.BridgeSizeDTO;
import bridge.dto.GameCommandDTO;
import bridge.dto.GameResultDTO;
import bridge.dto.MovingDTO;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void start() {
        printGameStartMessage();
        playBridgeGame(new BridgeGame(), createBridge());
    }
    
    private void printGameStartMessage() {
        outputView.printGameStartMessage();
    }
    
    private Bridge createBridge() {
        return new Bridge(new BridgeRandomNumberGenerator(), bridgeSize());
    }
    
    private int bridgeSize() {
        return inputBridgeSize().getBridgeSize();
    }
    
    private BridgeSizeDTO inputBridgeSize() {
        return inputView.readBridgeSize(outputView);
    }
    
    private void playBridgeGame(final BridgeGame bridgeGame, final Bridge bridge) {
        boolean isGameFinished = false;
        
        while (!isGameFinished) {
            isGameFinished = onceMoving(bridgeGame, bridge);
        }
        printResult(new GameResultDTO(bridgeGame));
    }
    
    private boolean onceMoving(final BridgeGame bridgeGame, final Bridge bridge) {
        move(bridgeGame, bridge);
        printResultMap(new GameResultDTO(bridgeGame));
        return isGameFinished(bridgeGame);
    }
    
    private void move(final BridgeGame bridgeGame, final Bridge bridge) {
        bridgeGame.move(inputMoving(), bridge);
    }
    
    private MovingDTO inputMoving() {
        return inputView.readMoving(outputView);
    }
    
    private void printResultMap(final GameResultDTO gameResultDTO) {
        outputView.printMap(gameResultDTO);
    }
    
    private boolean isGameFinished(final BridgeGame bridgeGame) {
        if (isMoveFailed(bridgeGame)) {
            return selectGameFinish(bridgeGame);
        }
        
        return bridgeGame.isGameFinished();
    }
    
    private boolean isMoveFailed(final BridgeGame bridgeGame) {
        return bridgeGame.isMoveFail();
    }
    
    private boolean selectGameFinish(final BridgeGame bridgeGame) {
        if (isGameCommandGameFinish(bridgeGame)) {
            return true;
        }
        
        initBridgeGameForRetry(bridgeGame);
        return false;
    }
    
    private boolean isGameCommandGameFinish(final BridgeGame bridgeGame) {
        return bridgeGame.selectGameFinish(gameCommand());
    }
    
    private String gameCommand() {
        return inputGameCommand().getGameCommand();
    }
    
    private GameCommandDTO inputGameCommand() {
        return inputView.readGameCommand(outputView);
    }
    
    private void initBridgeGameForRetry(final BridgeGame bridgeGame) {
        bridgeGame.retry();
    }
    
    private void printResult(final GameResultDTO gameResultDTO) {
        outputView.printResult(gameResultDTO);
    }
}

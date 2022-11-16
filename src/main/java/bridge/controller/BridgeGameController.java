package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.strategy.BridgeRandomNumberGenerator;
import bridge.dto.BridgeSizeDTO;
import bridge.dto.GameCommandDTO;
import bridge.dto.MovingDTO;
import bridge.view.InputView;

public class BridgeGameController {
    final InputView inputView;
    
    public BridgeGameController() {
        this.inputView = new InputView();
    }
    
    public void start() {
        final BridgeGame bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator(), inputBridgeSize());
    
        playBridgeGame(bridgeGame);
    }
    
    private void playBridgeGame(final BridgeGame bridgeGame) {
        boolean isGameFinished = false;
        while (!isGameFinished) {
            move(bridgeGame);
            isGameFinished = isGameFinished(bridgeGame);
        }
    }
    
    private boolean isGameFinished(final BridgeGame bridgeGame) {
        if (isMoveFail(bridgeGame)) {
            return selectGameFinish(bridgeGame);
        }
        
        return bridgeGame.isGameFinished();
    }
    
    private boolean isMoveFail(final BridgeGame bridgeGame) {
        return bridgeGame.isMoveFail();
    }
    
    private void move(final BridgeGame bridgeGame) {
        bridgeGame.move(inputMoving());
    }
    
    private MovingDTO inputMoving() {
        System.out.println("이동할 칸 입력");
        return inputView.readMoving();
    }
    
    private BridgeSizeDTO inputBridgeSize() {
        System.out.println("사다리 길이 입력");
        return inputView.readBridgeSize();
    }
    
    private boolean selectGameFinish(final BridgeGame bridgeGame) {
        if (inputGameCommand().equals("Q")) {
            return true;
        }
    
        initBridgeGameForRetry(bridgeGame);
        return false;
    }
    
    private void initBridgeGameForRetry(final BridgeGame bridgeGame) {
        bridgeGame.retry();
    }
    
    private String inputGameCommand() {
        System.out.println("재시도 입력");
        final GameCommandDTO gameCommandDTO = inputView.readGameCommand();
        return gameCommandDTO.getGameCommand();
    }
}

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
        playBridgeGame(new BridgeGame(new BridgeRandomNumberGenerator(), inputBridgeSize()));
    }
    
    private BridgeSizeDTO inputBridgeSize() {
        printBridgeSizeInputMessage();
        return inputView.readBridgeSize();
    }
    
    private void printBridgeSizeInputMessage() {
        System.out.println("사다리 길이 입력(3~20)");
    }
    
    private void playBridgeGame(final BridgeGame bridgeGame) {
        boolean isGameFinished = false;
        while (!isGameFinished) {
            move(bridgeGame);
            isGameFinished = isGameFinished(bridgeGame);
        }
    }
    
    private void move(final BridgeGame bridgeGame) {
        bridgeGame.move(inputMoving());
    }
    
    private MovingDTO inputMoving() {
        printMovingInputMessage();
        return inputView.readMoving();
    }
    
    private void printMovingInputMessage() {
        System.out.println("이동할 칸 입력(U, D)");
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
        if (inputGameCommand().equals("Q")) {
            return true;
        }
        
        initBridgeGameForRetry(bridgeGame);
        return false;
    }
    
    private String inputGameCommand() {
        printGameCommandInputMessage();
        final GameCommandDTO gameCommandDTO = inputView.readGameCommand();
        return gameCommandDTO.getGameCommand();
    }
    
    private void printGameCommandInputMessage() {
        System.out.println("재시도 입력(Q, R)");
    }
    
    private void initBridgeGameForRetry(final BridgeGame bridgeGame) {
        bridgeGame.retry();
    }
}

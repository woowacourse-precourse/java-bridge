package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.strategy.BridgeRandomNumberGenerator;
import bridge.dto.BridgeSizeDTO;
import bridge.dto.MovingDTO;
import bridge.view.InputView;

public class BridgeGameController {
    public void start() {
        final InputView inputView = new InputView();
        
        final BridgeSizeDTO bridgeSizeDTO = inputView.readBridgeSize();
        final BridgeGame bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator(), bridgeSizeDTO);
    
        boolean isGameFinished = false;
        while (!isGameFinished) {
            final MovingDTO movingDTO = inputView.readMoving();
            bridgeGame.move(movingDTO);
            isGameFinished = bridgeGame.isGameFinished();
        }
    }
}

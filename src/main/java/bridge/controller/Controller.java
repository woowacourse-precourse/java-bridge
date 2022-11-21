package bridge.controller;

import bridge.dto.Bridge;
import bridge.dto.MoveResult;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        outputView.printGameStart();

        Bridge bridge = generateBridge();

        Long playerId = bridgeGame.generatePlayer();

        crossBridgePlayer(playerId, bridge, getPlayerMoving());

    }

    private void crossBridgePlayer(Long playerId, Bridge bridge, String position) {
        MoveResult moveResult = bridgeGame.move(playerId, bridge, position);

        if(moveResult.isGameOver()){
            return;
        }
        crossBridgePlayer(playerId, bridge, getPlayerMoving());
    }

    private String getPlayerMoving() {
        try{
            return inputView.readMoving();
        } catch ( IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getPlayerMoving();
        }
    }

    private Bridge generateBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return bridgeGame.generateBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return generateBridge();
        }
    }

}
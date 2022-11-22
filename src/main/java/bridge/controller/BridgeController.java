package bridge.controller;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.Constants.*;

public class BridgeController {
    private Bridge bridge;
    private Player player;
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private int bridgeSize;

    public BridgeController(){
        player = new Player();
        inputView = new InputView();
        outputView = new OutputView();

        System.out.println(MESSAGE_GAME_START);
        bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeSize);
        bridgeGame = new BridgeGame(player, bridge, bridgeSize);
    }

    public void startBridge(){
        for(int i = 0; i < bridgeSize; i++){
            playBridgeGame(i);
        }
    }

    public void playBridgeGame(int blockNumber){
        boolean isSuccess = bridgeGame.move(inputView.readMoving());
        if(!isSuccess){
            restartBridgeGame(blockNumber);
        }
        if(isSuccess && blockNumber + 1 == bridgeSize){
            outputView.printResult(bridge, blockNumber, true, player);;
        }
    }

    public void restartBridgeGame(int blockNumber){
        String playerRetry = inputView.readGameCommand();
        if(playerRetry == PLAYER_RETRY)
            bridgeGame.retry();
        if(playerRetry == PLAYER_QUIT)
            outputView.printResult(bridge, blockNumber, false, player);;
    }
}


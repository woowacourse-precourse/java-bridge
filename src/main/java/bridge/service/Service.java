package bridge.service;

import bridge.domain.Result;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeGame;
import bridge.domain.player.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Service {
    private final Player player = new Player();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private Bridge bridge;
    private OutputView outputView = new OutputView();
    private Result result;
    public void makeBridge(int size){
        try {
            bridge = new Bridge(size);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makeBridge(size);
            return;
        }
    }
    public void makePlayer(){
        try {
            outputView.gamePrint();
            player.setInputMoving(inputView.readMoving());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makePlayer();
        }
    }
    public boolean movePlayer(int index){
        result = bridgeGame.move(bridge,player,index);
        outputView.plusResult(result.getResultType(),index);
        outputView.printMap();
        return result.getResultType().getWinLose();
    }
    public boolean retryPlayer(){
        try {
            if(!bridgeGame.retry(result)) {
                outputView.printRetry();
                player.setPlayerCommand(inputView.readGameCommand());
                if (player.getPlayerCommand().getPlayerCommandType()) {
                    outputView = new OutputView();
                    return true;
                }
            }
            return false;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return retryPlayer();
        }
    }
    public void endGame(){
        outputView.printResult(result.getResultType());
    }
}

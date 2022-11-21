package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeConstant;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame game;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker =new BridgeMaker(new BridgeRandomNumberGenerator());
    public void run(){
        prepareGame();
        while(true){
            if(!startGame()){
                if(!restartGame()) break;
            }
            if(game.checkSuccess()){
                break;
            }
        }
        resultAtGame();
    }
    private void prepareGame(){
        outputView.printStartMessages();
        int bridgeSize=inputView.readBridgeSize();
        game = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
    }
    private boolean startGame(){
        outputView.printMoveDirection();
        String userMovingInput = inputView.readMoving();
        boolean correct = game.move(userMovingInput);
        outputView.printMap(correct,userMovingInput);
        return correct;
    }
    private boolean restartGame(){
        outputView.printRetry();
        String retryCommand =inputView.readGameCommand();
        if(retryCommand.equals(BridgeConstant.RETRY.getString())){
            game.retry();
            outputView.reset();
            return true;
        }
        return false;
    }
    private void resultAtGame(){
        if(game.checkSuccess()){
            outputView.printResult(game.getTryNumber(),"성공");
            return;
        }
        outputView.printResult(game.getTryNumber(),"실패");
    }
}

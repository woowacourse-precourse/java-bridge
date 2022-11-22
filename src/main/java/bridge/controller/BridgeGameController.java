package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeConstant;
import bridge.constant.ResultConstant;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame game;
    private BridgeMaker bridgeMaker ;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
        bridgeMaker =new BridgeMaker(new BridgeRandomNumberGenerator());
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
            outputView.printResult(game.getTryNumber(), ResultConstant.SUCCESS.getKorean());
            return;
        }
        outputView.printResult(game.getTryNumber(),ResultConstant.FAIL.getKorean());
    }
}

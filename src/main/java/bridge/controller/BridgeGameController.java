package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.util.Constants;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BridgeGameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGame bridgeGame;
    public BridgeGameController(){
        outputView=new OutputView();
        inputView=new InputView();
        bridgeGame=new BridgeGame();
    }
    public void gameStart(){
        makeBridge();
        move(bridgeGame.getBridgeSize());
    }
    public int makeBridge(){
        outputView.printStartGame();
        bridgeGame.makeBridge(inputBridgeSize());
        return bridgeGame.getBridgeSize();
    }
    public int inputBridgeSize(){
        try {
            String bridgeSize=inputView.readBridgeSize();
            Validator.checkBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }
    public void move(int bridgeSize){
        boolean success=true;
        for(int i=0; i<bridgeSize; i++){
            if (moveOne(i).equals(Constants.WRONG)) {
                success=false;
                break;
            }
        }
        finalResult(success, bridgeGame.getTryCount());
    }
    public String moveOne(int index){
        String movingResult=bridgeGame.move(index, inputMoveOne(index));
        outputView.printMap(bridgeGame.getResult());
        return movingResult;
    }
    public String inputMoveOne(int index){
        String moving = inputView.readMoving();
        Validator.checkMoving(moving);
        return moving;
    }
    public boolean isQuit(){
        String retry=inputView.readGameCommand();
        Validator.checkRetryOrQuit(retry);
        if(retry.equals(Constants.QUIT)) return true;
        return false;
    }
    public void finalResult(boolean success, int tryCount){
        boolean quit=true;
        if(!success) quit=isQuit();
        if(quit || success)
            outputView.printResult(bridgeGame.getResult(), success, tryCount);
        if(!quit) {
            bridgeGame.retry();
            move(bridgeGame.getBridgeSize());
        }
    }
}

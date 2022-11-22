package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Constants;
import bridge.util.Validator;
import bridge.InputView;
import bridge.OutputView;

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
        outputView.printStartGame();
        makeBridge();
        move(bridgeGame.getBridgeSize());
    }
    public int makeBridge(){
        BridgeMaker bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge=bridgeMaker.makeBridge(inputBridgeSize());
        bridgeGame.makeBridge(bridge);
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
        isSuccess(success);
    }
    public String moveOne(int index){
        String movingResult=bridgeGame.move(index, inputMoveOne(index));
        outputView.printMap(bridgeGame.getResult());
        return movingResult;
    }
    public String inputMoveOne(int index){
        try {
            String moving = inputView.readMoving();
            Validator.checkMoving(moving);
            return moving;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMoveOne(index);
        }
    }
    public void finalResult(boolean success){
        outputView.printResult(bridgeGame.getResult(), success, bridgeGame.getTryCount());
    }
    public String inputRetryOrQuit(){
        try{
            String retryOrQuit=inputView.readGameCommand();
            Validator.checkRetryOrQuit(retryOrQuit);
            return retryOrQuit;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputRetryOrQuit();
        }
    }
    public void isSuccess(boolean success){
        if(success){
            finalResult(success);
            return;
        }
        isQuit(success);
    }
    public void isQuit(boolean success){
        String retryOrQuit=inputRetryOrQuit();
        if(retryOrQuit.equals(Constants.QUIT)) {
            finalResult(success);
            return;
        }
        retry();
    }
    public void retry(){
        bridgeGame.retry();
        move(bridgeGame.getBridgeSize());
    }
}

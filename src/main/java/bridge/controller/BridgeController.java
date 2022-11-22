package bridge.controller;


import bridge.constant.Letter;
import bridge.model.BridgeBuffer;
import bridge.model.BridgeGame;
import bridge.model.Column;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {
    private final InputView input;
    private final OutputView output;
    private final BridgeGame bridgeGame;
    private BridgeBuffer bridgeBuffer;

    public BridgeController(){
        input = new InputView();
        output = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void startGame(){
        int size = inputSize();
        bridgeBuffer = bridgeGame.start(size);
        running(size);
    }

    private int running(int size){
        for(int step = 0; step < size; step++) {
            if (checkAnswer(step)) {
                output.printMap(bridgeBuffer.getCurrent());
                continue;
            }
            return judgeFailureGame(step, size);
        }
        return succeedGame();
    }

    private boolean checkAnswer(int step){
        String position = inputMove();
        Column result = bridgeGame.move(step,position);
        if(result.isAnswer()){
            bridgeBuffer.add(result);
            return true;
        }
        return false;
    }

    private int judgeFailureGame(int step, int size){
        output.printMap(bridgeBuffer.addFailLetter(step,bridgeGame));
        return checkRetry(size);
    }

    private int checkRetry(int size){
        String letter = inputRetry();
        if(letter.equals(Letter.RETRY)){
            bridgeGame.retry();
            return running(size);
        }
        return failGame();
    }

    private int inputSize(){
        try {
            output.printIntro();
            return input.readBridgeSize();
        }catch (IllegalArgumentException e){
            output.printException(e.getMessage());
            return inputSize();
        }
    }
    private String inputMove(){
        try {
            output.printMove();
            return input.readMoving();
        }catch (IllegalArgumentException e){
            output.printException(e.getMessage());
            return inputMove();
        }
    }
    private String inputRetry(){
        try {
            output.printRetry();
            return input.readGameCommand();
        }catch (IllegalArgumentException e){
            output.printException(e.getMessage());
            return inputRetry();
        }
    }

    private int failGame(){
        output.printResult(bridgeBuffer.getResult(), Letter.FAILURE, bridgeGame.getTotalCount());
        return 0;
    }
    private int succeedGame(){
        output.printResult(bridgeBuffer.getResult(),Letter.SUCCESS, bridgeGame.getTotalCount());
        return 0;
    }
}

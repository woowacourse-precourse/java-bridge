package bridge.controller;

import bridge.constant.GameMessage;
import bridge.model.BridgeBuffer;
import bridge.model.BridgeGame;
import bridge.model.Column;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {
    private final InputView input;
    private final OutputView output;
    private final BridgeGame bridgeGame;
    private BridgeBuffer buffer;

    public BridgeController(){
        input = new InputView();
        output = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void startGame(){
        int size = inputSize();
        bridgeGame.start(size);
        playing(size);
    }

    private int playing(int size){
        for(int step = 0; step < size; step++) {
            if (checkAnswer(step)) {
                output.printMap(buffer.running());
                continue;
            }
            return judgeGameStatus(step, size);
        }
        return succeedGame();
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
    private boolean checkAnswer(int step){
        String position = inputMove();
        Column result = bridgeGame.move(step,position);
        if(result.isAnswer()){
            buffer.addColumn(result);
            return true;
        }
        return false;
    }

    private int judgeGameStatus(int step, int size){
        output.printMap(buffer.fail(step,bridgeGame));
        return checkRetry(size);
    }


    private int checkRetry(int size){
        String letter = inputRetry();
        if(letter.equals(GameMessage.RETRY)){
            bridgeGame.retry();
            return playing(size);
        }
        return failGame();
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
        output.printResult(buffer.over(), GameMessage.FAILURE, bridgeGame.getTotalCount());
        return 0;
    }
    private int succeedGame(){
        output.printResult(buffer.over(),GameMessage.SUCCESS, bridgeGame.getTotalCount());
        return 0;
    }
}

package bridge.controller;

import bridge.constant.GameMessage;
import bridge.model.BridgeBuffer;
import bridge.model.BridgeGame;
import bridge.model.Column;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private BridgeBuffer buffer;

    public BridgeController(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void startGame(){
        int size = inputSize();
        handleStartingGame(size);
        playing(size);
    }

    private int playing(int size){
        for(int step = 0; step < size; step++) {
            if (checkAnswer(step)) {
                outputView.printMap(buffer.running());
                continue;
            }
            return judgeGameStatus(step, size);
        }
        return succeedGame();
    }
    private int inputSize(){
        try {
            outputView.printIntro();
            return inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return handleStartGame();
        }
    }
    private String handleMoveGame(){
        try {
            outputView.printMove();
            String letter = inputView.readMoving();
            Column.validateLetter(letter);
            return letter;
        }catch (IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return handleMoveGame();
        }
    }
    private boolean checkAnswer(int step){
        String letter = handleMoveGame();
        Column answer = bridgeGame.move(step,letter);
        if(answer != Column.NONE){
            buffer.addColumn(answer);
            return true;
        }
        return false;
    }

    private int judgeGameStatus(int step, int size){
        outputView.printMap(buffer.fail(step,bridgeGame));
        return checkRetry(size);
    }


    private int checkRetry(int size){
        String letter = handleRetryGame();
        if(letter.equals(GameMessage.RETRY)){
            bridgeGame.retry();
            return playing(size);
        }
        return failGame();
    }
    private String handleRetryGame(){
        try {
            outputView.printRetry();
            String letter = validate.endLetter(inputView.readGameCommand());
            return letter;
        }catch (IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return handleRetryGame();
        }
    }

    private int failGame(){
        outputView.printResult(buffer.over(), GameMessage.FAILURE, bridgeGame.getTotalCount());
        return 0;
    }
    private int succeedGame(){
        outputView.printResult(buffer.over(),GameMessage.SUCCESS, bridgeGame.getTotalCount());
        return 0;
    }
}

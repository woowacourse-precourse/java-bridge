package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Column;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final ValidateInput validate;

    public BridgeController(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        validate = new ValidateInput();

    }
    private int handleStartGame(){
        try {
            outputView.printIntro();
            int size = validate.numeric(inputView.readBridgeSize());
            return size;
        }catch (IllegalArgumentException e){
            e.getMessage();
            return handleStartGame();
        }
    }
    private void handleStartingGame(int size){
        try {
            validate.size(size);
            bridgeGame.start(size);
        }catch (IllegalArgumentException e){
            e.getMessage();
            handleStartGame();
        }
    }

    public void startGame(){
        int size = handleStartGame();
        handleStartingGame(size);
        playing(size);
    }

    private int playing(int size){
        for(int step = 0; step < size; step++) {
            if (checkAnswer(step)) {
                outputView.printMap(bridgeGame.running());
                continue;
            }
            return judgeGameStatus(step, size);
        }
        return succeedGame();
    }
    private String handleMoveGame(){
        try {
            outputView.printMove();
            String letter = inputView.readMoving();
            Column.validateLetter(letter);
            return letter;
        }catch (IllegalArgumentException e){
            e.getMessage();
            return handleMoveGame();
        }
    }
    private boolean checkAnswer(int step){
        String letter = handleMoveGame();
        Column answer = bridgeGame.move(step,letter);
        if(answer != Column.NONE){
            bridgeGame.addColumn(answer);
            return true;
        }
        return false;
    }

    private int judgeGameStatus(int step, int size){
        outputView.printMap(bridgeGame.fail(step));
        return checkRetry(size);
    }

    private String handleRetryGame(){
        try {
            outputView.printRetry();
            String letter = validate.endLetter(inputView.readGameCommand());
            return letter;
        }catch (IllegalArgumentException e){
            e.getMessage();
            return handleRetryGame();
        }
    }
    private int checkRetry(int size){
        String letter = handleRetryGame();
        if(letter.equals(GameMessage.RETRY)){
            bridgeGame.retry();
            return playing(size);
        }
        return failGame();
    }

    private int failGame(){
        outputView.printResult(bridgeGame.over(), GameMessage.FAILURE, bridgeGame.getTotalCount());
        return 0;
    }
    private int succeedGame(){
        outputView.printResult(bridgeGame.over(),GameMessage.SUCCESS, bridgeGame.getTotalCount());
        return 0;
    }
}

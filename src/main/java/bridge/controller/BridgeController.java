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
    public void startGame(){
        outputView.printIntro();
        int size = validate.numeric(inputView.readBridgeSize());
        bridgeGame.start(size);
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

    private boolean checkAnswer(int step){
        outputView.printMove();
        String letter = inputView.readMoving();
        Column.validateLetter(letter);
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

    private int checkRetry(int size){
        outputView.printRetry();
        String letter = inputView.readGameCommand();
        validate.endLetter(letter);
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

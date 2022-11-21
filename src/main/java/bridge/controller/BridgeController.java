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
            judgeGameStatus(step, size);
        }
        return 0;
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
        if(step == size){
            succeedGame();
            return 0;
        }
        outputView.printMap(bridgeGame.fail(step));
        checkRetry(size);
        return 0;
    }

    private int checkRetry(int size){
        outputView.printRetry();
        String letter = inputView.readGameCommand();
        validate.endLetter(letter);
        if(letter == GameMessage.RETRY){
            bridgeGame.retry();
            return playing(size);
        }
        return failGame();
    }

    private int failGame(){
        outputView.printResult(bridgeGame.over(), GameMessage.FAILURE, bridgeGame.getTotalCount());
        return 0;
    }
    private void succeedGame(){
        outputView.printResult(bridgeGame.over(),GameMessage.SUCCESS, bridgeGame.getTotalCount());
    }
}

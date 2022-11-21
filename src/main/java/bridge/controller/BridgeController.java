package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Column;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {


    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private int totalCount;
    BridgeController(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        totalCount = 1;
    }
    public void startGame(){
        int size = ValidateInput.checkNumeric(inputView.readBridgeSize());
        bridgeGame.start(size);
        playing(size);
    }

    private int playing(int size){
        for(int step = 0; step < size; step++){
            if(checkAnswer(step)){
                addToBuffer(step);
                continue;
            }
            return judgeGameOver(step,size);
        }
        return 0;
    }

    private boolean checkAnswer(int step){
        String letter = inputView.readMoving();
        ValidateInput.checkLetter(letter);
        if(bridgeGame.move(step,letter)!= Column.NONE){
            return true;
        }
        return false;
    }
    private int judgeGameOver(int step, int size){
        if(step == size-1){
            //게임 끝
        }
        // 게임 다시 시도
        // 출력
       // return moveGame(size);
    }
    private void addToBuffer(String msg){

    }


}

package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Row;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {


    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final ValidateInput validate;
    private int totalCount;
    BridgeController(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        validate = new ValidateInput();
        totalCount = 1;
    }
    public void startGame(){
        int size = validate.numeric(inputView.readBridgeSize());
        bridgeGame.start(size);
        moveGame(size);
    }

    private int moveGame(int size){
        for(int step = 0; step < size; step++){
            if(bridgeGame.move(step,validate.letter(inputView.readMoving()))){
                continue;
            }
            return judgeGameEnd(step,size);
        }
        return 0;
    }
    private int judgeGameEnd(int step, int size){
        if(step == size-1){
            //게임 끝
        }
        // 게임 다시 시도
        // 출력
        return moveGame(size);
    }



}

package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Column;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class BridgeController {


    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final ValidateInput validate;
    private int totalCount;
    private List<List<String>> buffer;
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
        playing(size);
    }

    private int playing(int size){
        for(int step = 0; step < size; step++){
            if(checkAnswer(step)){
                continue;
            }
            return judgeGameOver(step,size);
        }
        return 0;
    }

    private void initializeBuffer(){
        buffer = new ArrayList<>();
        buffer.get(0).add(GameMessage.START);
        buffer.get(1).add(GameMessage.START);
    }
    private boolean checkAnswer(int step){
        String letter = inputView.readMoving();
        Column.validateLetter(letter);
        Column answer = bridgeGame.move(step,letter);
        if(answer != Column.NONE){
            addBridgeBuffer(answer);
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
        return 0;
    }
    private void addBridgeBuffer(Column answer){
        answer.getIndex();
    }



}

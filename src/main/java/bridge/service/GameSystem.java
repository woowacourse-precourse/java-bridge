package bridge.service;


import bridge.domain.AnswerBridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.domain.Player;

import java.util.Objects;

public class GameSystem {
    Player player;
    AnswerBridge answerBridge;
    int bridgeSize;
    public static final String UP_CHARACTER = "U";
    public static final String DOWN_CHARACTER = "D";
    private static final String SUCCESS_CHARACTER = "O";
    private static final String FAIL_CHARACTER = "X";
    private static final String BLANK_CHARACTER = " ";
    private static final String RETRY_CHARACTER = "R";
    public GameSystem(Player player,AnswerBridge answerBridge){
        this.player = player;
        this.answerBridge = answerBridge;
        this.bridgeSize = answerBridge.size;
    }

    public Boolean move(int index){
        String choice = InputView.readMoving();
        if(Objects.equals(choice, answerBridge.getAnswer().get(index))){
            moveSuccess(index,choice);
            OutputView.printMap(player,index);
            return true;
        }
        moveFail(index,choice);
        OutputView.printMap(player,index);
        return false;
    }

    public void moveSuccess(int index, String choice){
        if(Objects.equals(choice,UP_CHARACTER)) {
            player.bridges.upBridge.add(index,SUCCESS_CHARACTER);
            player.bridges.downBridge.add(index,BLANK_CHARACTER);
            return;
        }
        player.bridges.upBridge.add(index,BLANK_CHARACTER);
        player.bridges.downBridge.add(index,SUCCESS_CHARACTER);
    }

    public void moveFail(int index,String choice){
        if(Objects.equals(choice,UP_CHARACTER)) {
            player.bridges.upBridge.add(index, FAIL_CHARACTER);
            player.bridges.downBridge.add(index, BLANK_CHARACTER);
            return;
        }
        player.bridges.upBridge.add(index,BLANK_CHARACTER);
        player.bridges.downBridge.add(index,FAIL_CHARACTER);
    }

    public Boolean retryOrNot(){
        String retry = InputView.readGameCommand();
        if(Objects.equals(retry,RETRY_CHARACTER)) return true;

        return false;
    }

    public void printResult(Boolean moveSuccess,int trialNumber){
        OutputView.printFinalResult(player.bridges,moveSuccess,trialNumber);
    }

}

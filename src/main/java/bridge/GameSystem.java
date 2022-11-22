package bridge;

import view.InputView;

import java.util.Objects;

public class GameSystem {
    Player player;
    AnswerBridge answerBridge;
    int bridgeSize;
    public GameSystem(Player player,AnswerBridge answerBridge){
        this.player = player;
        this.answerBridge = answerBridge;
        this.bridgeSize = answerBridge.size;
    }

    public Boolean move(int index){
        String choice = InputView.readMoving();
        if(Objects.equals(choice, answerBridge.answer.get(index))){
            System.out.println("SUCCESS");
            moveSuccess(index,choice);
            OutputView.printMap(player,index);
            return true;
        }
        System.out.println("FAIL");
        moveFail(index,choice);
        OutputView.printMap(player,index);
        return false;
    }

    public void moveSuccess(int index, String choice){
        if(Objects.equals(choice,"U")) {
            player.bridges.upBridge.add(index,"O");
            player.bridges.downBridge.add(index," ");
        }
        if(Objects.equals(choice, "D")){
            player.bridges.upBridge.add(index," ");
            player.bridges.downBridge.add(index,"O");
        }
    }
    public void moveFail(int index,String choice){
        if(Objects.equals(choice,"U")) {
            player.bridges.upBridge.add(index,"X");
            player.bridges.downBridge.add(index," ");
        }
        if(Objects.equals(choice,"D")){
            player.bridges.upBridge.add(index," ");
            player.bridges.downBridge.add(index,"X");
        }
    }

    public void printResult(Boolean moveSuccess,int trialNumber){
        OutputView.printFinalResult(player.bridges,moveSuccess,trialNumber);
    }
}

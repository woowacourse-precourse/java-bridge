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

    public void printResult(Boolean moveSuccess,int trialNumber){
        OutputView.printFinalResult(player.bridges,moveSuccess,trialNumber);
    }
}

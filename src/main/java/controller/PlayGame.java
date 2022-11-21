package controller;

import model.BridgeGame;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class PlayGame {
    private List<String> crossAble;
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    public PlayGame(List<String> crossAble) {
        this.crossAble = crossAble;
    }

    public void playGame() {
        int turn = 0;
        int tryCount = 1;
        int endTurn = inputView.setBridgeSize();
        while(turn < endTurn) {
            Boolean matchResult = bridgeGame.move(crossAble, turn);
            if(!matchResult) {
                Boolean isRetry = bridgeGame.retry();
                tryCount++;
                if(isRetry){
                    continue;
                }
                endTurn = turn+1;
                break;
            }
            turn++;
        }
        List<HashMap> bridge = List.of(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
        System.out.println("최종 게임 결과");
        outputView.printMap(endTurn, bridge);
        outputView.printResult(endTurn, bridge, tryCount);
    }
}

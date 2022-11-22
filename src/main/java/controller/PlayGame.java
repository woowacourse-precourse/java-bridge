package controller;

import model.BridgeGame;
import view.InputView;
import view.OutputStatic;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class PlayGame {
    private List<String> crossAble;
    private int endTurn;

    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    public PlayGame(List<String> crossAble, int endTurn) {
        this.crossAble = crossAble;
        this.endTurn = endTurn;
    }

    public void playGame() {
        int turn = 0;
        int tryCount = 1;
        while(turn < endTurn) {
            String move = inputView.readMoving();
            Boolean matchResult = bridgeGame.move(crossAble, turn, move);
            if(!matchResult) {
                String gameCommand = inputView.setGameCommand();
                Boolean isRetry = bridgeGame.retry(gameCommand);
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
        System.out.println(OutputStatic.END_GAME_TITLE.getOutputPrint());
        outputView.printMap(endTurn, bridge);
        outputView.printResult(endTurn, bridge, tryCount);
    }
}

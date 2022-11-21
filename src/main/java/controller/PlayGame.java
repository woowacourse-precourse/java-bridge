package controller;

import model.BridgeGame;
import view.InputView;
import view.OutputView;

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
        int endTurn = inputView.setBridgeSize();
        while(turn < endTurn) {
            String move = inputView.setMoving();
            Boolean matchResult = crossAble.get(turn).equals(move);
            outputView.store(matchResult, move, turn);
            turn++;
        }
        outputView.printMap(endTurn);
    }
}

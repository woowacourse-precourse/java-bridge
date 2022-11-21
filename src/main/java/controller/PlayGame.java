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
        int endTurn = inputView.setBridgeSize();
        while(turn < endTurn) {
            bridgeGame.move(crossAble, turn);
            turn++;
        }
        outputView.printMap(endTurn, bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
    }
}

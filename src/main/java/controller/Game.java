package controller;

import view.InputView;

import java.util.List;

public class Game {

    private final InputView inputView = new InputView();

    public void play() {
        PrepareGame prepareGame = new PrepareGame(inputView.setBridgeSize());
        List<String> crossAble = prepareGame.prepareGame();
        PlayGame playGame = new PlayGame(crossAble, 3);
        playGame.playGame();
    }
}

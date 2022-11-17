package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.PrintSentence;

import java.util.List;

public class ProgressGame {
    InputView input = new InputView();
    OutputView output = new OutputView();
    private static final int INCORRECT = 0;
    private static final int CORRECT = 1;
    BridgeGame game;
    public ProgressGame(BridgeGame game) {
        this.game = game;
        progressGame();
    }
    private void progressGame() {
        while (true) {
            String move = inputMove();
            if (!distinguishMove(move)) {
                break;
            }
            if (game.getNowPosition() == game.getBridge().size()) {
                output.printResult(game, 1);
                break;
            }
        }
    }

    private void correctProcess() {
        output.printMap(game,CORRECT);
        game.move();
    }

    private void incorrectProecess() {
        output.printMap(game, INCORRECT);
        System.out.println(PrintSentence.RESTART_REQUEST.getSentence());
        if (input.readGameCommand().equals("R")) {
            game.retry();
            progressGame();
            return ;
        }
        output.printResult(game, 0);
    }

    private String inputMove() {
        System.out.println(PrintSentence.MOVE_REQUEST.getSentence());
        String move = input.readMoving();
        return move;
    }

    private boolean distinguishMove(String move) {
        int nowPosition = game.getNowPosition();
        List<String> bridge = game.getBridge();
        if (bridge.get(nowPosition).equals(move)) {
            correctProcess();
            return true;
        }
        incorrectProecess();
        return false;
    }
}

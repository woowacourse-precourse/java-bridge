package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Life;
import bridge.domain.Moving;
import bridge.view.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PlayingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final List<Moving> movings;
    private int playCount;


    public PlayingController(BridgeGame bridgeGame) {
        inputView = new InputView();
        outputView = new OutputView();
        this.bridgeGame = bridgeGame;
        movings = new ArrayList<>();
        playCount = 1;
    }

    public void play() {
        Life life = bridgeGame.getLife(move());
        outputView.printMap(List.copyOf(movings), life);
        if (life == Life.SAFE) {
            playByClear();
        }
        if (life == Life.DEAD) {
            retryByInput();
        }
    }

    private Moving move() {
        outputView.printInputMoving();
        Moving input = inputView.readMoving();
        bridgeGame.move();
        movings.add(input);
        return input;
    }

    private void playByClear() {
        if (!bridgeGame.isClear()) {
            play();
        }
    }

    private void retryByInput() {
        outputView.printGameCommand();
        GameCommand gameCommand = inputView.readGameCommand();
        if (gameCommand == GameCommand.R) {
            retry();
        }
    }

    private void retry() {
        playCount = playCount + 1;
        movings.clear();
        bridgeGame.retry();
        play();
    }
}

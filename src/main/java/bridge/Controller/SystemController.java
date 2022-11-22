package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import bridge.View.Message;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class SystemController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final InputValidation inputValidation = new InputValidation();
    private static final BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private int bridgeSize;
    private String move;
    private boolean keepPlaying = true;
    private List<String> answers = new ArrayList<>();
    private String inputRetry;
    private String successOrNot = "실패";

    public void SystemController() {
        System.out.printf(Message.START_GAME.getView());
        bridgeMake();
        game();
        result();
    }

    private void result() {
        outputView.printResult(bridgeGame.getPlayCount(), successOrNot);
    }

    private void bridgeMake() {
        inputBridgeSize();
        bridge(bridgeSize);
    }

    private void game() {
        while (keepPlaying) {
            inputBridgeMove();
            play();
            retryGame();
            endGame();
        }
    }

    private void endGame() {
        if (bridgeGame.getMoveCount() - 1 == bridgeSize) {
            keepPlaying = false;
            successOrNot = "성공";
        }
    }

    private void retryGame() {
        if (!(keepPlaying)) {
            inputRetry();
            bridgeGame.retry(inputRetry);
            keepPlaying = bridgeGame.getKeepPlaying();
            setRetry();
        }
    }

    private void play() {
        bridgeGame.move(move, answers);
        outputView.printMap(bridgeGame.getUpperMap(), bridgeGame.getLowerMap());
        keepPlaying = bridgeGame.getKeepPlaying();
    }


    private void setRetry() {
        bridgeGame.setMoveCount();
        bridgeGame.setMap();
    }

    private void inputRetry() {
        try {
            inputRetry = inputView.readGameCommand();
            inputValidation.validateCommand(inputRetry);
        } catch (IllegalArgumentException e) {
            System.out.printf(Message.ERROR_RETRY.getView());
            inputRetry();
        }
    }

    private void inputBridgeSize() {
        try {
            String inputSize = inputView.readBridgeSize();
            bridgeSize = Integer.parseInt(inputSize);
            inputValidation.validateSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.printf(Message.ERROR_SIZE.getView());
            inputBridgeSize();
        }
    }

    private void inputBridgeMove() {
        try {
            move = inputView.readMoving();
            inputValidation.validateMove(move);
        } catch (IllegalArgumentException e) {
            System.out.printf(Message.ERROR_MOVE.getView());
            inputBridgeMove();
        }
    }

    private void bridge(int size) {
        answers = bridgeMaker.makeBridge(size);
    }
}

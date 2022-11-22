package bridge.controller;

import bridge.model.*;
import bridge.model.message.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ExceptionController exceptionController = new ExceptionController();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final BridgeGame bridgeGame = new BridgeGame();
    private final Player player = new Player();
    private final Bridge bridge;
    private boolean playing = true;

    public Controller() {
        System.out.println(Message.START_GAME);
        bridge = makeBridge();
    }

    private Bridge makeBridge() {
        System.out.println(Message.INPUT_SIZE);
        int bridgeSize = inputView.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(madeBridge);
    }

    public void run() {
        while (playing) {
            move();
            checkCorrectChoice();
            checkApproachLast();
        }
    }

    private void move() {
        System.out.println(Message.INPUT_MOVING.getMessage());
        String choice = inputView.readChoice();
        bridgeGame.move(player, choice);
        outputView.printMap(player.getChoices(), bridge.compareTo(player.getChoices()));
    }

    private void checkCorrectChoice() {
        if (!isCorrectChoice()) {
            System.out.println(Message.INPUT_RETRY_COMMAND);
            String retryCommand = inputView.readRetryCommand();
            if (isRestart(retryCommand)) {
                bridgeGame.retry(player);
                return;
            }

            playing = false;
        }
    }

    private boolean isCorrectChoice() {
        List<String> answers = bridge.getAnswers();
        List<String> choices = player.getChoices();
        int lastStep = player.getStep();

        return bridgeGame.isCorrectChoice(answers, choices, lastStep);
    }

    private boolean isRestart(String retryCommand) {
        if (retryCommand.equals(Message.RE_START)) {
            return true;
        }
        return false;
    }

    private void checkApproachLast() {
        boolean isApproachLast = bridgeGame.isApproachLast(bridge.getAnswersSize(), player.getChoicesSize());

        if (playing && isApproachLast) {
            playing = false;
        }
    }
}

package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Player;
import bridge.model.Bridge;
import bridge.model.constant.Message;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final Player player = new Player();
    private final Bridge bridge;
    private boolean playing = true;

    public BridgeController() {
        System.out.println(Message.START_MESSAGE);
        bridge = makeBridge();
    }

    private Bridge makeBridge() {
        System.out.println(Message.INPUT_BRIDGE_LENGTH);
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

        finishGame();
    }

    private void move() {
        System.out.println(Message.INPUT_MOVING);
        String choice = inputView.readChoice();
        bridgeGame.move(player, choice);
        outputView.printMap(player.getChoices(), bridge.compareTo(player.getChoices()));
    }

    private void checkCorrectChoice() {
        if (isCorrectChoice()) {
            return;
        }
        readRetry();
    }

    private void readRetry() {
        System.out.println(Message.INPUT_RETRY_COMMAND);
        String retryCommand = inputView.readRetryCommand();

        if (isRestart(retryCommand)) {
            bridgeGame.retry(player);
            return;
        }
        playing = false;
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

    private void finishGame() {
        System.out.println(Message.GAME_RESULT_MESSAGE);
        outputView.printMap(player.getChoices(), bridge.compareTo(player.getChoices()));

        boolean isSuccess = isCorrectChoice() && bridgeGame.isApproachLast(bridge.getAnswersSize(), player.getChoicesSize());
        outputView.printResult(isSuccess, player.getTryCount());
    }
}

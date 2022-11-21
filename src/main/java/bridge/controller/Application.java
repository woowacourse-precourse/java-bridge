package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.Player;
import bridge.model.constant.Message;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Player player = new Player();
    private Bridge bridge;
    boolean playing = true;

    public void run() {
        startGame();

        while(playing) {
            move();
            checkCorrectChoice();
            checkApproachEndPoint();
        }

        finishGame();
    }

    private void startGame() {
        System.out.println(Message.START_MESSAGE);
        makeAnswerBridge();
    }

    private void makeAnswerBridge() {
        int bridgeSize = InputView.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge(madeBridge);
    }

    private void move() {
        String choice = InputView.readChoice();
        bridgeGame.move(player, choice);
        OutputView.printMap(player.getChoices(), bridge.compareTo(player.getChoices()));
    }

    private void checkCorrectChoice() {
        if (!isCorrectChoice()) {
            String retryCommand = InputView.readRetryCommand();
            if (retryCommand.equals(Message.RE_START)) {
                bridgeGame.retry(player);
                return;
            }

            playing = false;
        }
    }

    private void checkApproachEndPoint() {
        boolean isApproachEndPoint = bridge.isApproachEndPoint(player.getChoices());
        if (playing && isApproachEndPoint) {
            playing = false;
        }
    }

    private boolean isCorrectChoice() {
        return bridge.isCorrectChoice(player.getStep(), player.getLastChoice());
    }

    private void finishGame() {
        OutputView.printResult(player, bridge.compareTo(player.getChoices()));
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}

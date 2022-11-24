package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.util.InputConstant;
import bridge.util.MessageConstant;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private Result result;

    public Controller(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        outputView.printStartMessage();
        outputView.printInputLengthMessage();
    }

    public int inputBridgeLength() {
        while (true) {
            try {
                String length = inputView.input();
                return inputView.readBridgeSize(length);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public String inputDirection() {
        while (true) {
            try {
                String direction = inputView.input();
                return inputView.readMoving(direction);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void setUpBridge(int size) {
        result = new Result();
        bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(size)), result);
    }

    public void initialize() {
        int size = inputBridgeLength();
        setUpBridge(size);
    }
    public void play(Player player) throws IllegalArgumentException {
        player.tryGame();
        do {
            outputView.printMap(result);
            outputView.printSelectDirectionMessage();
            bridgeGame.move(inputDirection());
        } while (!bridgeGame.isFinish());
        outputView.printMap(result);
        outputView.printResult(player, result, MessageConstant.SUCCESS.getValue());
    }
    public void compareDecision(String decision, Player player) {
        if(decision.equals(InputConstant.RESTART.getValue())) {
            result = new Result();
            bridgeGame.initialize(result);
            start(player);
        }
        if(decision.equals(InputConstant.QUIT.getValue())) {
            outputView.printResult(player, result, MessageConstant.FAIL.getValue());
        }
    }
    public void decisionGameContinuous(Player player) {
        while(true) {
            try {
                String decision = inputView.input();
                compareDecision(inputView.readGameCommand(decision), player);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
    public void start(Player player) {
        try {
            play(player);
        } catch (IllegalArgumentException e) {
            outputView.printMap(result);
            outputView.printErrorMessage(e.getMessage());
            decisionGameContinuous(player);
        }
    }
}

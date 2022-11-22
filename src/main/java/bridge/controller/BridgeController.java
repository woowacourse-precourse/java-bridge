package bridge.controller;

import bridge.domain.Bridge;
import bridge.service.BridgeService;
import bridge.domain.Player;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeService bridgeService;

    public BridgeController(InputView inputView, OutputView outputView, BridgeService bridgeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeService = bridgeService;
    }

    public Bridge makeBridge() {
        return bridgeService.buildBridge(getBridgeSize());
    }

    public Player makePlayer(Bridge bridge) {
        return bridgeService.createPlayer(bridge);
    }

    public void startNewRound(Player player) {
        bridgeService.startNewRound(player);
    }

    public boolean canMove(Player player) {
        return bridgeService.checkMovable(player);
    }

    public int makeStep(Player player) {
        return bridgeService.makeStep(player,getStep());
    }

    public boolean checkSuccess(Player player) {
        return bridgeService.checkSuccess(player);
    }

    public void showWelcome() {
        outputView.printGameStart();
    }

    private int getBridgeSize() {
        Integer bridgeSize = null;
        return getValidBridgeSize(bridgeSize);
    }

    private Integer getValidBridgeSize(Integer bridgeSize) {
        while (bridgeSize == null) {
            outputView.printAskForBridgeSize();
            try {
                bridgeSize = inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return bridgeSize;
    }

    public String getRetryCommand() {
        String command = null;
        return getValidRetryCommand(command);
    }

    private String getValidRetryCommand(String command) {
        while (command == null) {
            outputView.printAskForRetry();
            try {
                command = inputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return command;
    }

    private String getStep() {
        String step = null;
        return getValidStep(step);
    }

    private String getValidStep(String step) {
        while (step == null) {
            outputView.printAskForStep();
            try {
                step = inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return step;
    }

    public void showProgress(Player player) {
        outputView.printMap(player);
    }

    public void showResult(Player player) {
        outputView.printResult(player);
    }
}

package bridge.controller;

import bridge.domain.Bridge;
import bridge.service.BridgeService;
import bridge.domain.Player;
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
        outputView.printAskForBridgeSize();
        return inputView.readBridgeSize();
    }

    public String getWantToRetry() {
        outputView.printAskForRetry();
        return inputView.readGameCommand();
    }

    private String getStep() {
        outputView.printAskForStep();
        return inputView.readMoving();
    }

    public void showProgress(Player player) {
        outputView.printMap(player);
    }

    public void showResult(Player player) {
        outputView.printResult(player);
    }
}

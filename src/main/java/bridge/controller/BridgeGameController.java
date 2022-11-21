package bridge.controller;

import bridge.domain.BridgeCell;
import bridge.BridgeNumberGenerator;
import bridge.domain.Command;
import bridge.service.BridgeGameService;

public class BridgeGameController {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final BridgeGameService service;

    public BridgeGameController(BridgeNumberGenerator bridgeNumberGenerator, BridgeGameService service) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.service = service;
    }

    public void createBridge(int bridgeSize) {
        service.createBridge(bridgeSize, bridgeNumberGenerator);
    }

    public boolean moveBridge(String move) {
        BridgeCell cell = BridgeCell.getBridgeCell(move);
        return service.moveBridge(cell);
    }

    public String createMap() {
        return service.createMap();
    }

    public boolean runCommand(String input) {
        Command command = Command.getCommand(input);
        if (command == Command.RETRY) {
            return service.retryGame();
        }
        return false;
    }

    public boolean checkGameProgress() {
        return service.checkGameProgress();
    }

    public String createResult() {
        return service.createResult();
    }
}

package bridge.controller;

import bridge.controller.dto.GameResult;
import bridge.controller.dto.MoveResult;
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

    public MoveResult moveBridge(String move) {
        BridgeCell cell = BridgeCell.getBridgeCell(move);

        boolean isMove = service.moveBridge(cell);
        boolean isEnd = service.checkGameProgress();
        String map = service.createMap();

        return new MoveResult(isMove, isEnd, map);
    }

    public boolean runCommand(String input) {
        Command command = Command.getCommand(input);
        if (command == Command.RETRY) {
            return service.retryGame();
        }
        return false;
    }

    public GameResult createResult() {
        String map = service.createMap();
        String result = service.createResult();
        return new GameResult(map, result);
    }
}

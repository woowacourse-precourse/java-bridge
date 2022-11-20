package bridge.controller;

import bridge.domain.bridgegame.GameResult;
import bridge.dto.BridgeGameDto;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static bridge.BridgeMaker.LOWER_BRIDGE;
import static bridge.BridgeMaker.UPPER_BRIDGE;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void generateBridgeGame() {
        OutputView.startGame();
        HashMap<String, List<String>> gameMap = new HashMap<>();
        gameMap.put(UPPER_BRIDGE, new ArrayList<>());
        gameMap.put(LOWER_BRIDGE, new ArrayList<>());

        BridgeGameDto bridgeGameDto = BridgeGameDto.from(gameMap);
        bridgeGameService.initBridgeGame(bridgeGameDto);
    }

    public void crossBridge(String movingDirection, boolean movingSuccess) {
        bridgeGameService.crossBridge(movingDirection, movingSuccess);
        OutputView.printMap(bridgeGameService.getGameMap());
    }

    public void printResult(boolean gameClear) {
        OutputView.printResult(bridgeGameService.getGameMap(), GameResult.toString(gameClear));
    }

    public void retryGame() {
        bridgeGameService.retryGame();
    }
}
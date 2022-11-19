package bridge.controller;

import bridge.dto.BridgeGameDto;
import bridge.service.BridgeGameService;

import java.util.List;

public class BridgeGameController {
    private final static List<String> INIT_GAME_MAP = List.of("", "");

    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void generateBridgeGame() {
        BridgeGameDto bridgeGameDto = BridgeGameDto.from(INIT_GAME_MAP);
        bridgeGameService.initBridgeGame(bridgeGameDto);
    }
}

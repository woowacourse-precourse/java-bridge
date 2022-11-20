package bridge.controller;

import bridge.dto.BridgeGameDto;
import bridge.service.BridgeGameService;

import java.util.ArrayList;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void generateBridgeGame() {
        BridgeGameDto bridgeGameDto = BridgeGameDto.from(new ArrayList<>(), new ArrayList<>());
        bridgeGameService.initBridgeGame(bridgeGameDto);
    }
}

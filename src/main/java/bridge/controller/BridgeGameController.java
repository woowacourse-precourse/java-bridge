package bridge.controller;

import bridge.dto.BridgeGameDto;
import bridge.service.BridgeGameService;
import bridge.service.PlayerService;
import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;

import java.util.List;

public class BridgeGameController {
    private final static List<String> INIT_GAME_MAP = List.of("", "");

    private final BridgeGameService bridgeGameService = new BridgeGameService();
    private final PlayerService playerService = new PlayerService();

    public void generateBridgeGame() {
        BridgeGameDto bridgeGameDto = BridgeGameDto.from(INIT_GAME_MAP);
        bridgeGameService.initBridgeGame(bridgeGameDto);
    }

    public void moveToNext() {
            String movingDirection = InputView.readMoving();

            try {
                MovingDirectionValidator.validateDirection(movingDirection);
                int currentDistance = playerService.getMovedDistance();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                moveToNext();
        }
    }
}

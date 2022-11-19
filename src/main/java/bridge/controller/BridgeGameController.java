package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.BridgeGameDto;
import bridge.exception.NotNumericException;
import bridge.service.BridgeGameService;
import bridge.service.PlayerService;
import bridge.utils.StringUtils;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;

public class BridgeGameController {

    private final BridgeGameService bridgeGameService = new BridgeGameService();
    private final PlayerService playerService = new PlayerService();

    public void generateBridgeGame() {
        String input = InputView.readBridgeSize();

        try {
            initBridgeGame(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            generateBridgeGame();
        }
    }

    private void initBridgeGame(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotNumericException();
        }

        int bridgeSize = Integer.parseInt(input);
        BridgeSizeValidator.validateBridgeSize(bridgeSize);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameDto bridgeGameDto = BridgeGameDto.from(bridgeMaker.makeBridge(bridgeSize));
        bridgeGameService.initBridgeGame(bridgeGameDto);
    }

    public void moveToNext() {
            String movingDirection = InputView.readMoving();

            try {
                MovingDirectionValidator.validateDirection(movingDirection);
                int currentDistance = playerService.getMovedDistance();
                bridgeGameService.isPassable(currentDistance, movingDirection);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                moveToNext();
        }
    }
}

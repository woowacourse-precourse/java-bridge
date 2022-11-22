package bridge.controller;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import bridge.service.BridgeService;
import bridge.utils.InputParser;

import java.util.List;

public class BridgeGameController {

    private final BridgeService bridgeService;

    public BridgeGameController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public ViewStatus makeBridge(String size) {
        try {
            return bridgeService.makeBridge(InputParser.parseToInteger(size));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return ViewStatus.DETERMINE_BRIDGE_SIZE;
        }
    }

    //입력 잘못된경우엔 빈 결과를 반환한다.
    public GameResult move(String moveCommand) {
        try {
            return bridgeService.move(InputParser.parseToUpperCase(moveCommand));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return GameResult.of(List.of(), ViewStatus.INVALID_MOVE_INPUT);
        }
    }

    public ViewStatus retry(String command) {
        try {
            return bridgeService.retry(InputParser.parseToUpperCase(command));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return ViewStatus.DETERMINE_CONTINUE;
        }
    }

    public int getGameCount() {
        return bridgeService.getGameCount();
    }
}

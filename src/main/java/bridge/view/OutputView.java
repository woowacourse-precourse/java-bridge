package bridge.view;

import static bridge.domain.util.Message.BRIDGE_SIZE_MESSAGE;
import static bridge.domain.util.Message.COUNT_MESSAGE;
import static bridge.domain.util.Message.ERROR_MESSAGE;
import static bridge.domain.util.Message.FAIL_MESSAGE;
import static bridge.domain.util.Message.MOVE_MESSAGE;
import static bridge.domain.util.Message.RESULT_MESSAGE;
import static bridge.domain.util.Message.RETRY_MESSAGE;
import static bridge.domain.util.Message.START_MESSAGE;
import static bridge.domain.util.Message.SUCCESS_MESSAGE;
import static bridge.domain.util.Rules.DELIMITER;
import static bridge.domain.util.Rules.END;
import static bridge.domain.util.Rules.START;

import bridge.domain.UserBridge;
import bridge.dto.UserBridgeDto;
import bridge.service.BridgeGameService;
import java.util.List;


public class OutputView {

    public void printMap(UserBridge userBridge) {
        UserBridgeDto userBridgeDto = UserBridgeDto.from(userBridge);
        printBridge(userBridgeDto.getUpBridge());
        printBridge(userBridgeDto.getDownBridge());
        System.out.println();
    }

    private void printBridge(List<String> bridge) {
        System.out.println(START + String.join(DELIMITER, bridge) + END);
    }

    public void printResult(BridgeGameService bridgeGameService, boolean success) {
        System.out.println(RESULT_MESSAGE);
        printMap(bridgeGameService.getUserBridge());
        printResultMessage(!success, FAIL_MESSAGE);
        printResultMessage(success, SUCCESS_MESSAGE);
        printCount(bridgeGameService.getCount());
    }

    private static void printResultMessage(boolean success, String message) {
        if (success) {
            System.out.println(message);
        }
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printMove() {
        System.out.println(MOVE_MESSAGE);
    }

    public void printCount(int count) {
        System.out.println(COUNT_MESSAGE + count);
    }

    public void printRetry() {
        System.out.println(RETRY_MESSAGE);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }
}

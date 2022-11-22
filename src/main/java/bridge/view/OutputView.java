package bridge.view;

import bridge.service.BridgeGame;
import java.util.List;
import java.util.Map;

import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.MovableSpace.LOWER_SPACE;
import static bridge.util.constants.RecordKey.UPPER_RECORD_KEY;
import static bridge.util.constants.RecordKey.LOWER_RECORD_KEY;
import static bridge.util.constants.GameCommand.RETRY;
import static bridge.util.constants.GameCommand.QUIT;
import static bridge.view.Message.GAME_START_MESSAGE;
import static bridge.view.Message.BRIDGE_SIZE_INPUT_REQUEST_MESSAGE;
import static bridge.view.Message.MOVING_SPACE_INPUT_REQUEST_MESSAGE;
import static bridge.view.Message.SPACE_DELIMITER;
import static bridge.view.Message.ENTRANCE_OF_BRIDGE;
import static bridge.view.Message.EXIT_OF_BRIDGE;
import static bridge.view.Message.GAME_COMMAND_INPUT_REQUEST_MESSAGE;
import static bridge.view.Message.FINAL_GAME_RESULT_MESSAGE;
import static bridge.view.Message.GAME_SUCCESS_OR_NOT_MESSAGE;
import static bridge.view.Message.TOTAL_TRY_COUNT_MESSAGE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 패키지 변경가능, 메서드 이름 변경 불가. 인자와 반환타입은 추가 및 변경 가능
 * 메서드 추가 가능
 */
public class OutputView {
    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE.getMessage());
    }

    public void printBridgeSizeInputRequest() {
        System.out.println(BRIDGE_SIZE_INPUT_REQUEST_MESSAGE.getMessage());
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMovingSpaceInputRequest() {
        String message = String.format(MOVING_SPACE_INPUT_REQUEST_MESSAGE.getMessage(),
                UPPER_SPACE.getValue(), LOWER_SPACE.getValue());
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        Map<String, List<String>> crossedRecord = bridgeGame.getCrossedRecord();
        printUpperPart(crossedRecord.get(UPPER_RECORD_KEY.getValue()));
        printLowerPart(crossedRecord.get(LOWER_RECORD_KEY.getValue()));
    }

    private void printUpperPart(List<String> upperCrossedRecord) {
        String upperPart = String.join(SPACE_DELIMITER.getMessage(), upperCrossedRecord);
        System.out.println(ENTRANCE_OF_BRIDGE.getMessage() + upperPart + EXIT_OF_BRIDGE.getMessage());
    }

    private void printLowerPart(List<String> lowerCrossedRecord) {
        String lowerPart = String.join(SPACE_DELIMITER.getMessage(), lowerCrossedRecord);
        System.out.println(ENTRANCE_OF_BRIDGE.getMessage() + lowerPart + EXIT_OF_BRIDGE.getMessage());
    }

    public void printGameCommandInputRequest() {
        String message = String.format(GAME_COMMAND_INPUT_REQUEST_MESSAGE.getMessage(),
                RETRY.command(), QUIT.command());
        System.out.println(message);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(FINAL_GAME_RESULT_MESSAGE.getMessage());
        printMap(bridgeGame);
        printSuccessOrFail(bridgeGame.isFailed());
        printTryCount(bridgeGame);
    }

    private void printSuccessOrFail(boolean isFailed) {
        String successResult = Message.getSuccessResultMessage(isFailed);
        System.out.println(GAME_SUCCESS_OR_NOT_MESSAGE.getMessage() + successResult);
    }

    private void printTryCount(BridgeGame bridgeGame) {
        int tryCount = bridgeGame.getTryCount();
        System.out.println(TOTAL_TRY_COUNT_MESSAGE.getMessage() + tryCount);
    }
}

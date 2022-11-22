package bridge.controller;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import bridge.service.BridgeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameControllerTest {

    private final BridgeGameController bridgeGameController =
            new BridgeGameController(new BridgeService());

    @DisplayName("범위를 초과하는 값을 입력하면 사이즈를 재입력하도록 한다.")
    @ValueSource(strings = {"1", " 21   ", " 30 ", "-1"})
    @ParameterizedTest
    void notChangeStatusWhenInputOutOfRange(String size) {
        assertThat(bridgeGameController.makeBridge(size))
                .isEqualTo(ViewStatus.DETERMINE_BRIDGE_SIZE);
    }

    @DisplayName("범위 이내의 값을 입력하면 움직임을 입력하도록 한다.")
    @ValueSource(strings = {"13", " 10   ", " 6", "3"})
    @ParameterizedTest
    void changeStatusWhenInputIsInRange(String size) {
        assertThat(bridgeGameController.makeBridge(size))
                .isEqualTo(ViewStatus.DETERMINE_MOVE);
    }

    @DisplayName("잘못된 move 명령어 입력 시 그에 맞는 상태값 반환.")
    @ValueSource(strings = {"b", " dfa", "dd"})
    @ParameterizedTest
    void returnStatusWhenMoveCommandIsInvalid(String command) {
        bridgeGameController.makeBridge("3");
        GameResult result = bridgeGameController.move(command);

        assertThat(result.getNextViewStatus())
                .isEqualTo(ViewStatus.INVALID_MOVE_INPUT);
    }

    @DisplayName("올바른 move 명령어 입력 시 그에 맞는 상태값 반환.")
    @ValueSource(strings = {"d", "U ", " D ", "        u "})
    @ParameterizedTest
    void returnStatusWhenMoveCommandIsValid(String command) {
        bridgeGameController.makeBridge("3");
        GameResult result = bridgeGameController.move(command);

        assertThat(result.getNextViewStatus())
                .isNotEqualTo(ViewStatus.INVALID_MOVE_INPUT);
    }

    @DisplayName("잘못된 retry 명령어 입력 시 그에 맞는 상태값 반환.")
    @ValueSource(strings = {"rr", "1 ", " dfa ", "       a d "})
    @ParameterizedTest
    void returnStatusWhenInputInvalidRetryCommand(String command) {
        bridgeGameController.makeBridge("3");
        ViewStatus result = bridgeGameController.retry(command);

        assertThat(result)
                .isEqualTo(ViewStatus.DETERMINE_CONTINUE);
    }

    @DisplayName("올바른 retry 명령어 입력 시 그에 맞는 상태값 반환.")
    @ValueSource(strings = {"r", "R ", " Q ", "        q "})
    @ParameterizedTest
    void returnStatusWhenValidRetryCommand(String command) {
        bridgeGameController.makeBridge("3");
        ViewStatus result = bridgeGameController.retry(command);

        assertThat(result)
                .isNotEqualTo(ViewStatus.DETERMINE_CONTINUE);
    }

    @DisplayName("게임 카운트 반환.")
    @ValueSource(ints = {1, 2, 3, 4})
    @ParameterizedTest
    void returnGameCount(int count) {
        bridgeGameController.makeBridge("3");
        retryMultipleTime(count);
        int result = bridgeGameController.getGameCount();

        assertThat(result).isEqualTo(count + 1);
    }

    private void retryMultipleTime(int count) {
        for (int retryCount = 1; retryCount <= count; retryCount++) {
            bridgeGameController.retry("R");
        }
    }
}
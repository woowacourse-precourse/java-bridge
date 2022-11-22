package bridge.service;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeServiceTest {

    private final BridgeService bridgeService = new BridgeService();

    @DisplayName("size 입력값이 범위를 초과한 경우 오류를 반환한다.")
    @ValueSource(ints = {21, 40, -1})
    @ParameterizedTest
    void throwErrorWhenSizeIsInvalid(int size) {
        assertThatThrownBy(() ->
                bridgeService.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("size 입력값이 범위 이내이면 적절한 상태값을 반환한다.")
    @ValueSource(ints = {20, 3, 5})
    @ParameterizedTest
    void returnMakeBridgeResponseWhenSizeIsInvalid(int size) {
        assertThat(bridgeService.makeBridge(size))
                .isEqualTo(ViewStatus.DETERMINE_MOVE);
    }

    @DisplayName("move 명령어 입력 값이 잘못된 경우 오류를 반환한다.")
    @ValueSource(strings = {"a", "t", "1"})
    @ParameterizedTest
    void throwErrorWhenInputWrong(String command) {
        bridgeService.makeBridge(3);

        assertThatThrownBy(() -> bridgeService.move(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("move 명령어 입력이 적절한 경우 그에 맞는 결과값을 반환한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void returnResultWhenInputValid(String command) {
        bridgeService.makeBridge(3);

        assertThat(bridgeService.move(command))
                .isInstanceOf(GameResult.class);
    }
}
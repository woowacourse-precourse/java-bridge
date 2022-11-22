package bridge.service;

import bridge.TestNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BridgeGameService와 관련된 테스트를 진행한다.")
class BridgeGameServiceTest {

    private static BridgeGameService bridgeGameService;

    @BeforeEach
    void init() {
        bridgeGameService = new BridgeGameService();
        bridgeGameService.makeBridge(3, TestNumberGenerator.from(List.of(1, 0, 0)));
    }

    @DisplayName("이동 후 성공 여부를 표시하는 메서드를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"U, true", "D, false"})
    void returnTrueWhenMoveSuccess(final String command, final boolean result) {
        assertThat(bridgeGameService.moveAndReturnSuccess(command)).isEqualTo(result);
    }
}
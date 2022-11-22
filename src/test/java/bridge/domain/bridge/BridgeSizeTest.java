package bridge.domain.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeSizeTest {

    @ParameterizedTest
    @DisplayName("다리 사이즈 입력 범위 오류 검증")
    @ValueSource(strings = {"2", "31", "0", "-1"})
    void 다리_사이즈는_3부터_20까지만_가능하다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BridgeSize(input))
                .withMessageContaining(BridgeSize.ERROR_BRIDGE_SIZE_RANGE);
    }

    @ParameterizedTest
    @DisplayName("다리 사이즈 입력 타입 오류 검증")
    @ValueSource(strings = {"a", "abc", " ", "?"})
    void 다리_사이즈는_숫자만_받아야_한다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BridgeSize(input))
                .withMessageContaining(BridgeSize.CHAR_ERROR_MESSAGE);
    }
}
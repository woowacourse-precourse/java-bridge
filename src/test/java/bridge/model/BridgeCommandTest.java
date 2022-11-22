package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeCommandTest {

    @DisplayName("재시도 문자가 R,Q 이 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"A", "@#%@#", "123", "r", "u", "D", "U"})
    void 재시도_종료_문자_형식_예외_테스트(String command) {
        assertThatThrownBy(() -> BridgeCommand.createBridgeCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

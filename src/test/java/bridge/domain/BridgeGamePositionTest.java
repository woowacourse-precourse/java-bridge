package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
class BridgeGamePositionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"TTTTTT", "               U", "D          ", "jejuneLee"})
    void check_validate_input_bridge_position(final String input) {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> BridgeGamePosition.checkBridgePosition(input));
            BridgeGamePosition.checkBridgePosition(input);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("U,D 만 입력 가능합니다");
        }
    }

}
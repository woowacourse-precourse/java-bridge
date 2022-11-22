package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeGameCommandTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"TTTTTT", "               U", "D          ", "jejuneLee"})
    void check_validate_input_bridge_command(final String input) {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> BridgeGameCommand.checkGameCommand(input));
            BridgeGameCommand.checkGameCommand(input);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("R,Q 만 입력 가능합니다");
        }
    }

}
package bridge.domain.code;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgePositionTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 4, 5})
    void 다리의_위치는_0과_1이외의_값을_가질_수_없습니다(final Integer input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgePosition.convertValueToCode(input))
                .withMessageContaining(BridgePosition.ERROR_NOT_FOUND_POSITION_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", " ", "  "})
    void 다리의_입력_명령어는_U_와_D만_존재합니다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgePosition.convertCodeToPosition(input))
                .withMessageContaining(BridgePosition.ERROR_DID_NOT_FOUND_CODE);
    }
}
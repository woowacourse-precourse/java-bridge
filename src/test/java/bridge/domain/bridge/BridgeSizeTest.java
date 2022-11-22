package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeSizeTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "", " s ", "##", "$$"})
    void 다리의_길이는_숫자가_아닌_다른_값을_가질_수_없습니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BridgeSize(input))
                .withMessageContaining(BridgeSize.ERROR_INPUT_IS_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "-1", "21", "22"})
    void 다리의_길이는_3이상_20이하입니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BridgeSize(input))
                .withMessageContaining(BridgeSize.ERROR_SIZE_IN_RANGE);
    }

}
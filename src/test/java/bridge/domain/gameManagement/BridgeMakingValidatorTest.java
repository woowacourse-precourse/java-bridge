package bridge.domain.gameManagement;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakingValidatorTest {
    @EmptySource
    @ParameterizedTest
    void 다리의_길이가_입력되지_않았을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> BridgeMakingValidator.validateEmptyBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이가 입력되지 않았습니다.");
    }

    @ValueSource(strings = {"bcd", "54d", "4^&$#", "가나다라", "ㄱㄴㄷ"})
    @ParameterizedTest
    void 숫자가_아니거나_숫자가_아닌_문자가_포함되어_있을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> BridgeMakingValidator.validateOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.");
    }

    @ValueSource(strings = {"-1", "0", "2", "21", "30"})
    @ParameterizedTest
    void 다리의_길이_범위를_벗어나는_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> BridgeMakingValidator.validateBridgeSizeRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
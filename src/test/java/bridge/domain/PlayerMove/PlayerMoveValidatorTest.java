package bridge.domain.PlayerMove;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerMoveValidatorTest {
    @EmptySource
    @ParameterizedTest
    void 이동할_칸이_입력되지_않았을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PlayerMoveValidator.validateEmptyBridgeMovingPosition(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동할 칸이 입력되지 않았습니다.");
    }

    @ValueSource(strings = {"abc", "가나", "UUU", "DD", "^^^"})
    @ParameterizedTest
    void 이동할_칸이_1글자가_아닐_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PlayerMoveValidator.validateMovingPositionLengthRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동할 칸은 문자 1글자만 입력되어야 합니다.");
    }

    @ValueSource(strings = {"R", "Q", "가", "A", "4"})
    @ParameterizedTest
    void 이동할_칸이_U_또는_D가_아닐_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PlayerMoveValidator.validateNotUpAndDownCharacter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 이동할 칸은 문자 U와 D가 아닙니다. U 또는 D만 입력해주세요.");
    }
}
package bridge.domain.gameOver;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class GameRestartOrQuitValidatorTest {
    @EmptySource
    @ParameterizedTest
    void 게임_재시작_또는_종료_여부가_입력되지_않았을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> GameRestartOrQuitValidator.validateEmptyGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 게임 재시작 또는 종료 여부가 입력되지 않았습니다.");
    }

    @ValueSource(strings = {"11", "ABC", "RR", "가나다라", "QR"})
    @ParameterizedTest
    void 게임_재시작_또는_종료_여부가_1글자가_아닐_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> GameRestartOrQuitValidator.validateGameCommandLengthRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 게임 재시작 또는 종료 여부는 문자 1글자만 입력되어야 합니다.");
    }

    @ValueSource(strings = {"A", "B", "1", "가", "$"})
    @ParameterizedTest
    void 게임_재시작_또는_종료_여부가_R_또는_Q가_아닐_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> GameRestartOrQuitValidator.validateNotRestartAndDownCharacter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값은 문자 R과 Q가 아닙니다. 게임 재시작 또는 종료 여부로 R 또는 Q만 입력해주세요.");
    }
}
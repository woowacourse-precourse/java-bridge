package bridge.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IllegalArgumentTest {

    @ValueSource(strings = {"숫자아님", "", " ", "\n", "jkdf", "3d"})
    @ParameterizedTest
    void 숫자가_아닌_다리의_길이_입력값(String input) {
        assertThat(IllegalArgument.isNotNumber(input)).isTrue();
    }

    @ValueSource(strings = {"0", "1", "3", "20", "21"})
    @ParameterizedTest
    void 숫자인_다리의_길이_입력값(String input) {
        assertThat(IllegalArgument.isNotNumber(input)).isFalse();
    }

    @ValueSource(strings = {"0", "1", "2", "21"})
    @ParameterizedTest
    void 다리의_길이_범위_밖_입력값(String input) {
        assertThat(IllegalArgument.isNotInBridgeSizeRange(input)).isTrue();
    }

    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void 다리의_길이_범위_안_입력값(String input) {
        assertThat(IllegalArgument.isNotInBridgeSizeRange(input)).isFalse();
    }

    @ValueSource(strings = {"0", "", "d", "30", "E"})
    @ParameterizedTest
    void 이동할_칸_올바르지_않은_입력(String input) {
        assertThat(IllegalArgument.isIncorrectMoving(input)).isTrue();
    }

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동할_칸_올바른_입력(String input) {
        assertThat(IllegalArgument.isIncorrectMoving(input)).isFalse();
    }

    @ValueSource(strings = {"D", "", "3"})
    @ParameterizedTest
    void 재시작_또는_종료_올바르지_않은_입력(String input) {
        assertThat(IllegalArgument.isIncorrectGameCommand(input)).isTrue();
    }

    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 재시작_또는_종료_올바른_입력(String input) {
        assertThat(IllegalArgument.isIncorrectGameCommand(input)).isFalse();
    }
}

package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {
    @ValueSource(strings = {"03", "3.0", "a", "a2", "+3", "-3", "0", "", " ", "\n", "ㄱ", "1_000_000_000"})
    @ParameterizedTest(name = "[{index}] input = {0}")
    void 다리_개수_양의_정수_이외의_예외처리_테스트(String input) {
        assertThatThrownBy(() -> Validation.isPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 10억 미만의 양의 정수이어야 합니다.");
    }

    @ValueSource(ints = {1,2,21,100,999_999_999})
    @ParameterizedTest(name = "[{index}] input = {0}")
    void 다리_길이_범위_테스트(int input) {
        assertThatThrownBy(() -> Validation.isInRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @ValueSource(strings = {"a", "u", "d", "", " ", " \n", "0", "3", "U "})
    @ParameterizedTest(name = "[{index}] input = {0}[test]")
    void 이동할_다리_위치_검증_테스트(String input) {
        assertThatThrownBy(() -> Validation.validateMoveTo(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 이동할 다리는 위(U) 또는 아래(D) 이어야 합니다.");
    }

    @ValueSource(strings = {"a", "r", "q", "", " ", " \n", "0", "3", "R ", "RR"})
    @ParameterizedTest(name = "[{index}] input = {0}[test]")
    void 재시작_여부_검증_테스트(String input) {
        assertThatThrownBy(() -> Validation.validateRestart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 재시도 여부는 종료(Q) 또는 재시도(R) 이어야 합니다.");
    }
}
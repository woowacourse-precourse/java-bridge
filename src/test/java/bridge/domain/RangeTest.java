package bridge.domain;

import bridge.exception.InvalidRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RangeTest {

    @DisplayName("3 미만 20 초과의 숫자가 들어오면 에러를 발생한다.")
    @ValueSource(ints = {2, 21})
    @ParameterizedTest
    void checkValidateByWrongRangeInteger(Integer integer) {
        assertThatThrownBy(() -> Range.validate(integer))
                .isInstanceOf(InvalidRangeNumberException.class);
    }

    @DisplayName("3 이상 20 이하의 숫자가 들어오면 정상적으로 통과한다.")
    @ValueSource(ints = {3, 12, 20})
    @ParameterizedTest
    void checkValidateByCorrectRangeInteger(Integer integer) {
        Range.validate(integer);
    }
}

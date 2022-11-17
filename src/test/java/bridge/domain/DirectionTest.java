package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @DisplayName("숫자 0은 D을 의미하고 숫자 1은 U을 의미한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:D","1:U"},delimiter = ':')
    void Direction에서_정수와_String의_연관관계_테스트(int intArg, String expected) {
        assertThat(Direction.getDirectionStringByNumber(intArg)).isEqualTo(expected);
    }

    @DisplayName("0,1 이외의 정수 값을 넣는다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,2,3,4,5,6,7})
    void Direction에서_정수와_String의_연관관계_테스트(int intArg) {
        assertThatThrownBy(()->Direction.getDirectionStringByNumber(intArg))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 방향으로 전환 될 수 없는 숫자의 입력 입니다.");
    }
}
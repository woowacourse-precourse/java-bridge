package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @DisplayName("숫자 0은 D을 의미하고 숫자 1은 U을 의미한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:D", "1:U"}, delimiter = ':')
    void Direction에서_정수와_String의_연관관계_테스트(int intArg, String expected) {
        assertThat(Direction.getDirectionStringByNumber(intArg)).isEqualTo(expected);
    }

    @DisplayName("0,1 이외의 정수 값을 넣는다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 4, 5, 6, 7})
    void Direction에서_정수와_String의_연관관계_테스트(int intArg) {
        assertThatThrownBy(() -> Direction.getDirectionStringByNumber(intArg))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 방향으로 전환 될 수 없는 숫자의 입력 입니다.");
    }

    @DisplayName("스트링을 U를 입력하면 Direction U, R을 입력하면 Direction R을 반환해야한다")
    @ParameterizedTest
    @CsvSource(value = {"U", "D"})
    void String을_이용한_Direction_반환_테스트(String stringArgs) {
        Direction expected = Direction.D;
        if (stringArgs.equals("U")) {
            expected = Direction.U;
        }
        assertThat(Direction.getDirectionByString(stringArgs)).isEqualTo(expected);
    }

    @DisplayName("스트링을 U,D외의 값을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource(value = {"A", "BC", "TEST"})
    void String을_이용한_Direction_예외_테스트(String stringArgs) {
        assertThatThrownBy(() -> Direction.getDirectionByString(stringArgs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
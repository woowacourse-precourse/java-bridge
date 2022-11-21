package bridge.commom.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LocationTableTest {

    @DisplayName("U(upper) 또는 D(down) 값을 통해서 적절한 인덱스(0,1)을 반환한다.")
    @ParameterizedTest(name = "인덱스 반환 테스트[{index}] => {0}을 넣으면 {1}이 나와야한다.")
    @CsvSource(value = {"U:1", "D:0"}, delimiter = ':')
    void putKeyThenReturningAppropriateIndex(String key, int expected) {
        int actual = LocationTable.getIndexWithKey(key);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("인덱스를 통해서 U(upper) 또는 D(down) 값을 반환한다.")
    @ParameterizedTest(name = "U, D 반환 테스트[{index}] => {0}을 넣으면 {1}이 나와야한다.")
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    void putIndexThenReturningAppropriateKey(int index, String expected) {
        String actual = LocationTable.getKeyWithIndex(index);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 커맨드 U(upper) 또는 D(down)의 대응되는 키를 반환한다.")
    @ParameterizedTest(name = "U, D 대응 키 반환 테스트[{index}] => {0}을 넣으면 {1}이 나와야한다.")
    @CsvSource(value = {"D:U", "U:D"}, delimiter = ':')
    void returningAlternativeKey(String source, String expected) {
        String actual = LocationTable.getAlternativeKey(source);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 커맨드 U(upper) 또는 D(down)의 대응되는 키가 없다면 예외를 발생한다.")
    @ParameterizedTest(name = "입력된 키의 대응키 여부 검사 테스트[{index}] => {0}은 대응되는 키가 존재하지 않는다.  ")
    @ValueSource(strings = {"A", "B", "C", "E", "F", "G", "H", "I", "J"})
    void ifNotPresentAlternativeKeyThenReturnException(String actual) {
        assertThatThrownBy(() -> LocationTable.getAlternativeKey(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("대응되는 키가 존재하지 않습니다.");
    }
}
package bridge.commom.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


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
}
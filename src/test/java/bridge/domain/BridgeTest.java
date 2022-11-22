package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @DisplayName("다리 길이가 3 ~ 20이 아닐 경우 예외가 발생한다.")
    @CsvSource(value = {"1", "2", "21", "22", "23"})
    @ParameterizedTest
    void makeWrongSize(int size) {
        assertThrows(IllegalArgumentException.class,
                () -> new Bridge(size));
    }

    @DisplayName("이동할 수 있다면 ture, 이동할 수 없다면 false를 확인한다.")
    @CsvSource(value = {
            "0, D, true",
            "1, D, true",
            "2, D, true",
            "0, U, false",
            "1, U, false",
            "2, U, false"})
    @ParameterizedTest
    void canMove(int place, String moving, boolean expected) {
        Bridge bridge = new Bridge(List.of("D", "D", "D"));
        boolean actual = bridge.canMove(place, moving);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("다리의 길이를 구한다.")
    @CsvSource(value = {
            "3, 3",
            "4, 4",
            "5, 5",
            "6, 6",
            "7, 7"})
    @ParameterizedTest
    void getBridgeSize(int size, int expected) {
        Bridge bridge = new Bridge(size);
        int actual = bridge.getSize();
        assertThat(actual).isEqualTo(expected);
    }
}

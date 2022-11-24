package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeDirectionTest {

    @DisplayName("숫자를 방향으로 변환한다.")
    @ParameterizedTest(name = "숫자가 {0}일 때, 방향은 {1}이다.")
    @CsvSource(value = {"1, UP", "0, DOWN"})
    void numberToDirection(int number, BridgeDirection direction) {
        BridgeDirection numberToDirection = BridgeDirection.numberToDirection(number);

        assertThat(direction).isEqualTo(numberToDirection);
    }

    @DisplayName("문자를 방향으로 변환한다.")
    @ParameterizedTest(name = "문자가 {0}일 때, 방향은 {1}이다.")
    @CsvSource(value = {"U, UP", "D, DOWN"})
    void numberToDirection(String word, BridgeDirection direction) {
        BridgeDirection wordToLocation = BridgeDirection.wordToDirection(word);

        assertThat(direction).isEqualTo(wordToLocation);
    }
}
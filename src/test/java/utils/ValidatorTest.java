package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @DisplayName("다리 길이 입력값이 3 미만, 20 초과일 경우와, 숫자가 아닌 경우 false 값이 반환된다.")
    @ValueSource(strings = {"2", "21", "30", "아아", "a"})
    @ParameterizedTest
    void invalidBridgeSizeInput(String bridgeSize) {
        assertThat(Validator.isValidBridgeSize(bridgeSize)).isFalse();
    }

    @DisplayName("다리 길이 입력값이 3 이상, 20 이하일 경우와, 숫자일 경우 true 값이 반환된다.")
    @ValueSource(strings = {"3", "20", "10"})
    @ParameterizedTest
    void validBridgeSizeInput(String bridgeSize) {
        assertThat(Validator.isValidBridgeSize(bridgeSize)).isTrue();
    }

    @DisplayName("이동할 칸이 U나 D가 아닐 경우, false 값이 반환된다.")
    @ValueSource(strings = {"s", "w", "30", "아아", "a"})
    @ParameterizedTest
    void invalidMovingPlace(String movingPlace) {
        assertThat(Validator.isValidMovingPlace(movingPlace)).isFalse();
    }

    @DisplayName("이동할 칸이 U나 D일 경우 true 값이 반환된다.")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void validMovingPlace(String movingPlace) {
        assertThat(Validator.isValidMovingPlace(movingPlace)).isTrue();
    }

    @DisplayName("다시 시도할 여부 입력 값이 R이나 Q가 아닐 경우 false 값이 반환된다.")
    @ValueSource(strings = {"s", "w", "30", "아아", "a"})
    @ParameterizedTest
    void invalidGameCommand(String gameCommand) {
        assertThat(Validator.isValidGameCommand(gameCommand)).isFalse();
    }

    @DisplayName("다시 시도할 여부 입력 값이 R이나 Q일 경우 true 값이 반환된다.")
    @ValueSource(strings = {"Q", "R"})
    @ParameterizedTest
    void validGameCommand(String gameCommand) {
        assertThat(Validator.isValidGameCommand(gameCommand)).isTrue();
    }
}

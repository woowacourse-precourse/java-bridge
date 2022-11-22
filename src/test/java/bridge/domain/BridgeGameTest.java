package bridge.domain;


import bridge.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    @DisplayName("다리 길이가 3 부터 20 사이라면 정상적으로 출력된다.")
    @Test
    void bridgeSizeOverThanThreeOrLessThanTwenty() {
        String bridgeSize = "14";
        int size = Integer.parseInt(bridgeSize);

        Assertions.assertThat((size > 2 && size < 21)).isTrue();
    }




    @DisplayName("다리 길이가 3보다 작으면 예외가 발생한다.")
    @Test
    void bridgeSizeLessThanThree() {
        String bridgeSize = "2";

        Assertions.assertThatThrownBy(() -> Validator.validateInputBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 실패 후 입력 값이 R, Q이면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q", "R"})
    void oneFailureAndSuccessTryCount(String command) {
        Assertions.assertThatCode(()-> Validator.validateRetryGameCommand(command))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동 실패 후 입력 값이 R, Q가 아니면 예러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5", "z", "H"})
    void retryGameCommandInputNotCorrect(String command) {
        Assertions.assertThatThrownBy(() -> Validator.validateRetryGameCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


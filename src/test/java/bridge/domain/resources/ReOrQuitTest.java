package bridge.domain.resources;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReOrQuitTest {

    ReOrQuit reOrQuit;

    @DisplayName("입력을 R이나 Q로 했을 경우 객체에 해당 값이 저장되는지 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void inputRQTest(String inputRQ) {
        reOrQuit = ReOrQuit.of(inputRQ);
        Assertions.assertThat(reOrQuit.getInputRQ())
                .isEqualTo(inputRQ);
    }

    @DisplayName("입력이 R이나 Q가 아닌 다른 것일 때 예외가 터지는지 테스트")
    @ValueSource(strings = {"r", "ㄲ", "0", ",", "~", "", "U", "D"})
    @ParameterizedTest
    void wrongInputRQTest(String wrongInput) {
        Assertions.assertThatThrownBy(() -> ReOrQuit.of(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
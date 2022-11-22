package bridge.domain.resources;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UpOrDownTest {

    @DisplayName("U와 D가 아닌 문자가 들어올 때 예외 메시지를 출력하며 잘 터지는지 테스트")
    @ValueSource(strings = {"r", "ㅅ", "1", ",", ""})
    @ParameterizedTest
    void upOrDownValidityTest(String inputs) {
        Assertions.assertThatThrownBy(() -> UpOrDown.of(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("input U, D가 잘 저장되는지 확인하는 테스트")
    @Test
    void inputUDTest() {
        UpOrDown up = UpOrDown.of(UpOrDown.UP);
        UpOrDown down = UpOrDown.of(UpOrDown.DOWN);

        Assertions.assertThat(up.getInputUD())
                .isEqualTo(UpOrDown.UP);
        Assertions.assertThat(down.getInputUD())
                .isEqualTo(UpOrDown.DOWN);
    }
}
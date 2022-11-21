package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.bridgeInfo.Length;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LengthTest {

    @DisplayName("다리의 길이가 3 이상 20 이하가 아니라면 예외가 발생한다.")
    @Test
    void createLengthByOverSize() {
        assertThatThrownBy(() -> new Length("30"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 공백이라면 예외가 발생한다.")
    @Test
    void createLengthWithBlank() {
        assertThatThrownBy(() -> new Length(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이에 문자가 포함되면 예외가 발생한다.")
    @Test
    void createLengthWithCharacter() {
        assertThatThrownBy(() -> new Length("4$"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
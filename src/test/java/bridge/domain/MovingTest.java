package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovingTest {
    @DisplayName("이동할 칸 입력 값이 길이가 1이 아니면 예외가 발생한다.")
    @Test
    void checkMovingInputByOverSize() {
        assertThatThrownBy(() -> new Moving("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 값이 U와 D가 아니면 예외가 발생한다.")
    @Test
    void checkMovingInputForm() {
        assertThatThrownBy(() -> new Moving("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
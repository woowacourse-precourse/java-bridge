package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("다리의 길이 입력이 3부터 20사이의 수가 아니라면 예외 발생")
    @Test
    void checkRange() {
        int input = 2;
        assertThatThrownBy(() -> Exception.lengthrangeException(2))
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}

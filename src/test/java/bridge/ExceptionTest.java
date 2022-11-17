package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @DisplayName("다리의 길이 입력이 3부터 20사이의 수가 아니라면 예외 발생")
    @Test
    void checkRangefalse() {
        assertThatThrownBy(() -> Exception.lengthrangeException(2))
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3부터 20사이의 수라면 예외가 발생하지 않음")
    @Test
    void checkRangetrue() {
        assertThatCode(() -> Exception.lengthrangeException(15))
                .doesNotThrowAnyException();
    }
}

package bridge.model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ResultTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 코드_심볼_변환() {
        assertThat(Result.getSymbol(1)).isEqualTo("U");
        assertThat(Result.getSymbol(0)).isEqualTo("D");
    }

    @Test
    void 심볼_코드_변환() {
        assertThat(Result.getCode("U")).isEqualTo(1);
        assertThat(Result.getCode("D")).isEqualTo(0);
    }

    @Test
    void 코드_심볼_변환_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Result.getCode("A"));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }

    @Test
    void 심볼_코드_변환_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Result.getSymbol(3));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }
}

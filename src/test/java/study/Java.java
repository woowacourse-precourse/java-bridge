package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class Java {
    @Test
    void java_isEmpty() {
        assertAll(
                () -> assertThat("".isEmpty()).isEqualTo(true),
                () -> assertThat(" ".isEmpty()).isEqualTo(false)
        );
    }
}

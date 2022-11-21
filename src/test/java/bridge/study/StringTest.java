package bridge.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String.format은 StringBuilder를 인자로 받을 수 있다")
    void String_format_인자값_테스트() {
        StringBuilder test = new StringBuilder();
        test.append("test");

        assertThat(String.format("[%s]",test)).isEqualTo("[test]");
    }
}

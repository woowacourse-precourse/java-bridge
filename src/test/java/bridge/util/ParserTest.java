package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void 다리의_길이_올바른_입력값_처리() {
        assertThat(new Parser().parseBridgeSize("3")).isEqualTo(3);
    }

    @Test
    void 다리의_길이_숫자가_아닌_입력값_예외_처리() {
        assertThatThrownBy(() ->
                new Parser().parseBridgeSize("java")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리의_길이_범위_밖_숫자_입력값_예외_처리() {
        assertThatThrownBy(() ->
                new Parser().parseBridgeSize("21")).isInstanceOf(IllegalArgumentException.class);
    }
}

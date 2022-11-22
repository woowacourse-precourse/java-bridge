package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

    @ValueSource(strings = {"3", "4", "5", "10", "20"})
    @ParameterizedTest
    void 다리의_길이_올바른_입력값_처리(String input) {
        assertThat(new Parser().parseBridgeSize(input)).isInstanceOf(Integer.class);
    }

    @ValueSource(strings = {"java", "2", "0", "30", "21"})
    @ParameterizedTest
    void 다리의_입력값_예외_처리(String input) {
        assertThatThrownBy(() ->
                new Parser().parseBridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"", "3", "d", "u"})
    @ParameterizedTest
    void 칸_이동_예외_처리(String input) {
        assertThatThrownBy(() ->
                new Parser().parseMoving(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 칸_이동_올바른_입력(String input) {
        assertThat(new Parser().parseMoving(input)).matches("[U|D]");
    }

    @ValueSource(strings = {"", "3", "r", "q"})
    @ParameterizedTest
    void 재시작_또는_종료_예외_처리(String input) {
        assertThatThrownBy(() ->
                new Parser().parseGameCommand(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 재시작_또는_종료_올바른_입력(String input) {
        assertThat(new Parser().parseGameCommand(input)).matches("[R|Q]");
    }
}

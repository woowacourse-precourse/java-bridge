package bridge.logger;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LoggerTest extends NsTest {

    @DisplayName("debug with only a message")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "message, [DEBUG] message"
    })
    void testDebug1(
            final String message,
            final String expectedLog
    ) {
        Logger.debug(message);
        assertThat(output()).isEqualTo(expectedLog);
    }

    @DisplayName("debug with message and integer")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "message, 0, [DEBUG] message: 0"
    })
    void testDebug2(
            final String message,
            final int integer,
            final String expectedLog
    ) {
        Logger.debug(message, integer);
        assertThat(output()).isEqualTo(expectedLog);
    }

    @DisplayName("debug with message and string")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "message, string, [DEBUG] message: ^string$"
    })
    void testDebug3(
            final String message,
            final String string,
            final String expectedLog
    ) {
        Logger.debug(message, string);
        assertThat(output()).isEqualTo(expectedLog);
    }

    @DisplayName("error with only a message")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "message, [ERROR] message"
    })
    void testError1(
            final String message,
            final String expectedLog
    ) {
        Logger.error(message);
        assertThat(output()).isEqualTo(expectedLog);
    }

    @DisplayName("error with message and integer")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "message, 0, [ERROR] message: 0"
    })
    void testError2(
            final String message,
            final int integer,
            final String expectedLog
    ) {
        Logger.error(message, integer);
        assertThat(output()).isEqualTo(expectedLog);
    }

    @DisplayName("error with message and string")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "message, string, [ERROR] message: ^string$"
    })
    void testError3(
            final String message,
            final String string,
            final String expectedLog
    ) {
        Logger.error(message, string);
        assertThat(output()).isEqualTo(expectedLog);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
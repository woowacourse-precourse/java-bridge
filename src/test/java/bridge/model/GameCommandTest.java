package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameCommand와 관련된 테스트를 진행한다.")
class GameCommandTest {

    @DisplayName("retry 명령어인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"R, true", "Q, false"})
    void returnTrueWhenCommandIsR(String command, boolean result) {
        assertThat(GameCommand.isRetryCommand(command)).isEqualTo(result);
    }
}
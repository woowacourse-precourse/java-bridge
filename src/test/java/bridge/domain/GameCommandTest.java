package bridge.domain;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandTest {


    @DisplayName("입력받은 문자열로 enum 반환")
    @ParameterizedTest
    @CsvSource(value = {"Q,QUIT", "R,RETRY"})
    void gameCommandFromTest(String value, GameCommand gameCommand) throws Exception {
        Assertions.assertThat(GameCommand.from(value)).isEqualTo(gameCommand);
    }

    @DisplayName("입력 불가능한 커맨드의 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"A", "B", "C"})
    void gameCommandFromFailTest(String value) throws Exception {
        Assertions.assertThatThrownBy(() -> GameCommand.from(value))
                .isInstanceOf(NoSuchElementException.class);
    }

}
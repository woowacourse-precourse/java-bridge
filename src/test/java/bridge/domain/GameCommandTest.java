package bridge.domain;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandTest {

    @DisplayName("입력 문자에 따라 Command를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"Q,QUIT","R,RETRY"})
    void returnCommand(String input, GameCommand gameCommand) {
        GameCommand result = GameCommand.of(input);

        assertThat(gameCommand).isEqualTo(result);
    }

}
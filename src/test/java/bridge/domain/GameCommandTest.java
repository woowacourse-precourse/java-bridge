package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandTest {


    @DisplayName("입력받은 문자열로 enum 반환")
    @ParameterizedTest
    @CsvSource(value = {"Q,QUIT", "R,RETRY"})
    void gameCommandFromTest(String inputLetter, GameCommand gameCommand) throws Exception {
        Assertions.assertThat(GameCommand.from(inputLetter)).isEqualTo(gameCommand);
    }

    @DisplayName("입력 불가능한 커맨드의 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"A", "B", "C"})
    void gameCommandFromFailTest(String inputLetter) throws Exception {
        Assertions.assertThatThrownBy(() -> GameCommand.from(inputLetter))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 커맨드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"Q", "R"})
    void hasCommandTest(String inputLetter) throws Exception {
        Assertions.assertThat(GameCommand.hasCommand(inputLetter)).isTrue();
    }

    @DisplayName("존재하지 않는 커맨드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"A", "B", "C"})
    void hasNotCommandTest(String inputLetter) throws Exception {
        Assertions.assertThat(GameCommand.hasCommand(inputLetter)).isFalse();
    }


}
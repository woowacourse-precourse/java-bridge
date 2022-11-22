package bridge.input.getter;

import bridge.input.getter.GameCommandGetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameCommandGetterTest {
    @ParameterizedTest
    @DisplayName("재시도/종료 여부 받아오기 기능 테스트: 올바르지 않은 입력일 경우 예외 발생")
    @ValueSource(strings = {"", "U", "D", "123", "567", "r", "q"})
    void getGameCommandTest_exceptionThrowingTest(String userInput) {
        GameCommandGetter getter = GameCommandGetter.getGameCommandGetter();

        System.setIn(new ByteArrayInputStream((userInput).getBytes()));

        assertThatThrownBy(getter::getGameCommandFromConsole)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("재시도/종료 여부 받아오기 기능 테스트: 올바른 입력일 경우 입력된 값을 반환")
    @ValueSource(strings = {"R", "Q"})
    void getGameCommandTest(String userInput) {
        GameCommandGetter getter = GameCommandGetter.getGameCommandGetter();

        System.setIn(new ByteArrayInputStream((userInput).getBytes()));

        assertThat(getter.getGameCommandFromConsole()).isEqualTo(userInput);
    }
}

package bridge.input.getter;

import bridge.input.getter.GameCommandGetter;
import bridge.input.getter.MoveGetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveGetterTest {
    @ParameterizedTest
    @DisplayName("다음으로 이동할 칸 받아오기 기능 테스트: 올바르지 않은 입력일 경우 예외 발생")
    @ValueSource(strings = {"", "u", "d", "123", "567", "r", "q", "R", "Q"})
    void getMoveTest_exceptionThrowingTest(String userInput) {
        MoveGetter getter = MoveGetter.getMoveGetter();

        System.setIn(new ByteArrayInputStream((userInput).getBytes()));

        assertThatThrownBy(getter::getMoveFromConsole)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("다음으로 이동할 칸 받아오기 기능 테스트: 올바른 입력일 경우 입력된 값을 반환")
    @ValueSource(strings = {"U", "D"})
    void getMoveTest(String userInput) {
        MoveGetter getter = MoveGetter.getMoveGetter();

        System.setIn(new ByteArrayInputStream((userInput).getBytes()));

        assertThat(getter.getMoveFromConsole()).isEqualTo(userInput);
    }
}

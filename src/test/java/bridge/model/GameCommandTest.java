package bridge.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCommandTest {
    @Nested
    @DisplayName("잘못된 인자를 넣으면")
    class OfStringCommandInvalidArgumentTest {

        @DisplayName("예외를 던진다.")
        @ParameterizedTest
        @ValueSource(strings = {"U", "D", "A", "1", "4", ":", " "})
        public void run(String arg) {
            assertThatIllegalArgumentException()
                    .isThrownBy(()->GameCommand.of(arg))
                    .withMessageStartingWith("게임 재시도 여부가 올바르지 않습니다.");
        }
    }
}

package bridge.model.bridge;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NodeTest {
    @Nested
    @DisplayName("of() 테스트")
    class OfTest {
        @ParameterizedTest
        @ValueSource(strings = {"R", "P", "1", "a", "ㄱ", " "})
        @DisplayName("잘못된 문자열 인자가 들어오면 예외를 던진다.")
        public void throwExceptionForInvalidArgument(String arg) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Node.of(arg))
                    .withMessageStartingWith("다리의 위치는 U 또는 D 이어야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 4, 5, 10, 100, 2344})
        @DisplayName("잘못된 정수 인자가 들어오면 예외를 던진다.")
        public void throwExceptionForInvalidArgument(int arg) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Node.of(arg))
                    .withMessageStartingWith("다리의 위치는 1 또는 0이어야합니다.");

        }
    }
}
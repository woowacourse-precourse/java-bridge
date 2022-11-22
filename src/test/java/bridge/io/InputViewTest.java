package bridge.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이 입력값 검증")
    @Nested
    class validateBridgeSizeTest {

        private void validateBridgeSize(final String bridgeSize) {
            final int size;
            try {
                size = Integer.parseInt(bridgeSize);
            } catch (final NumberFormatException e) {
                throw new NumberFormatException("[ERROR] bridge size는 숫자가 입력되어야 합니다.");
            }
            if (size > 20 || size < 3) {
                throw new IllegalArgumentException("[ERROR] bridge size는 3 이상 20 이하의 숫자만 입력 가능합니다.");
            }
        }

        @DisplayName("다리 길이 입력값 검증_성공")
        @Test
        void validateBridgeSizeTest_Success() {
            // Given
            final String size = "5";

            // When Then
            validateBridgeSize(size);
        }

        @DisplayName("다리 길이 입력값 검증_숫자가 아닌 값")
        @Test
        void validateBridgeSizeTest_NumberFormatException() {
            // Given
            final String size = "not_number";

            // When Then
            assertThatThrownBy(() -> validateBridgeSize(size))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @DisplayName("다리 길이 입력값 검증_3~20이 아닌 값")
        @ValueSource(strings = {"2", "21"})
        @ParameterizedTest
        void validateBridgeSizeTest_IllegalArgumentException(final String size) {
            // When Then
            assertThatThrownBy(() -> validateBridgeSize(size))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @DisplayName("다리 선택 입력값 검증")
    @Nested
    class validateCourseTest {

        private void validateCourse(final String course) {
            if (!course.equals("U") && !course.equals("D")) {
                throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D만 입력 가능합니다.");
            }
        }

        @DisplayName("다리 선택 입력값 검증_성공")
        @ValueSource(strings = {"U", "D"})
        @ParameterizedTest
        void validateCourseTest_Success(final String course) {
            // When Then
            validateCourse(course);
        }

        @DisplayName("다리 선택 입력값 검증_U 또는 D가 아닌 입력")
        @Test
        void validateCourseTest_IllegalArgumentException() {
            // Given
            final String course = "invalid";

            // When Then
            assertThatThrownBy(() -> validateCourse(course))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @DisplayName("retry 입력값 검증")
    @Nested
    class validateRestartCommandTest {

        private void validateRestartCommand(final String command) {
            if (!command.equals("R") && !command.equals("Q")) {
                throw new IllegalArgumentException("[ERROR] 커맨드는 R 또는 Q만 입력 가능합니다.");
            }
        }

        @DisplayName("retry 입력값 검증_성공")
        @ValueSource(strings = {"R", "Q"})
        @ParameterizedTest
        void validateRestartCommandTest_Success(final String command) {
            // When Then
            validateRestartCommand(command);
        }

        @DisplayName("retry 입력값 검증_R 또는 Q가 아닌 입력")
        @Test
        void validateRestartCommandTest_IllegalArgumentException() {
            // Given
            final String command = "invalid";

            // When Then
            assertThatThrownBy(() -> validateRestartCommand(command))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

}
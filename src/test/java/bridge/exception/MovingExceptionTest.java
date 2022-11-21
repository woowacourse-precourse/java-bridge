package bridge.exception;

import bridge.helper.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovingExceptionTest {

    UserException movingException = new MovingException();

    @ParameterizedTest
    @DisplayName("U, D 이외의 값을 입력하면 예외를 반환한다.")
    @MethodSource("generateData")
    void isNotMovingTest(String errorMoving) {
        assertThrows(IllegalArgumentException.class, () -> movingException.checkException(errorMoving));
    }

    @ParameterizedTest
    @DisplayName("U, D를 입력하면 통과한다.")
    @ValueSource(strings = {"U", "D"})
    void isMovingTest(String moving) {
        assertDoesNotThrow(() -> movingException.checkException(moving));
    }

    static List<String> generateData() {
        return TestData.generateExceptionData(68, 85);
    }
}
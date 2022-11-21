package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovingExceptionTest {

    UserException movingException = new MovingException();

    @ParameterizedTest
    @DisplayName("U, D 이외의 값을 입력하면 예외를 반환한다.")
    @MethodSource("generateData")
    void isNotMovingTest(String errorMoving) {
        assertThrows(IllegalArgumentException.class, () -> movingException.checkException(errorMoving));
    }

    static List<String> generateData() {
        List<String> data = new ArrayList<>();
        for (int i = 33; i < 127; i++) {
            if (i == 68 || i == 85) {
                continue;
            }
            char letter = (char) i;
            data.add(String.valueOf(letter));
        }
        return data;
    }
}
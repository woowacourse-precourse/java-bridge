package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeSizeExceptionTest {

    UserException bridgeSizeException = new BridgeSizeException();

    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 예외를 반환한다.")
    void isNotIntTest() {
        assertThrows(IllegalArgumentException.class, () -> bridgeSizeException.checkException("R"));
    }

    @ParameterizedTest
    @DisplayName("3 ~ 20 범위 size의 경계값 분석 테스트")
    @MethodSource("generateData")
    void outOfRangeTest(String errorSize, String size) {
        assertThrows(IllegalArgumentException.class, () -> bridgeSizeException.checkException(errorSize));
        assertDoesNotThrow(() -> bridgeSizeException.checkException(size));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("2", "3"),
                Arguments.of("21", "20")
        );
    }
}

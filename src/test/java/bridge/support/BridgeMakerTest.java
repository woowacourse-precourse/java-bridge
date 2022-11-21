package bridge.support;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BridgeMaker 객체 테스트")
class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("makeBridge 함수는 정수를 인자로받아 해당 정수 길이만큼의 List를 반환한다.")
    @ParameterizedTest(name = "입력값: {0}")
    @CsvSource({"3", "5", "20"})
    void testMakeBridgeMethod(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertEquals(bridge.size(), size);
    }

    @DisplayName("makeBridge 함수의 인자가 3 ~ 20 사이의 값이 아니면 예외")
    @ParameterizedTest(name = "{0}이면 예외")
    @CsvSource({"1", "0", "-1", "59", "1000000"})
    void parameterIsOutOfRange(int size) {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeMaker.makeBridge(size);
        });
    }

    @Test
    @DisplayName("makeBridge 가 반환한 List에는 U 혹은 D만 존재한다")
    void validateReturnValue() {
        List<String> bridge = bridgeMaker.makeBridge(20);
        Pattern pattern = Pattern.compile("[^U,^D]");
        bridge.forEach(floor -> {
            Matcher matcher = pattern.matcher(floor);
            Assertions.assertFalse(matcher.find());
        });
    }

}
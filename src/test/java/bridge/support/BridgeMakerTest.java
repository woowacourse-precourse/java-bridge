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

class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리의 길이가 3 ~ 20이 아니라면 예외")
    @ParameterizedTest(name = "{0}이면 예외")
    @CsvSource({"1", "0", "-1", "59", "1000000"})
    void outOfRange(int size) {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeMaker.makeBridge(size);
        });
    }

    @Test
    @DisplayName("다리에는 U, D값만 들어있다.")
    void validateField() {
        List<String> bridge = bridgeMaker.makeBridge(20);
        Pattern pattern = Pattern.compile("[^U,^D]");
        bridge.forEach(floor -> {
            Matcher matcher = pattern.matcher(floor);
            Assertions.assertFalse(matcher.find());
        });
    }

}
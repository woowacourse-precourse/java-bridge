package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BridgeGameTest extends NsTest {
    @Override
    protected void runMain() {
    }


    @DisplayName("입력받은 다리가 정상값으로 들어올 경우")
    @ParameterizedTest
    @MethodSource("inputSuccessBridge")
    public void success(List<String> value) {
        assertThat(new ValidateBridgeGame().validate(value))
                .isEqualTo(value);
    }

    static Stream<Arguments> inputSuccessBridge() {
        return Stream.of(
                Arguments.arguments(Arrays.asList("U", "D", "U", "D")),
                Arguments.arguments(Arrays.asList("D", "D", "D", "D")),
                Arguments.arguments(Arrays.asList("U", "D", "D")),
                Arguments.arguments(Arrays.asList("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"))
        );
    }


    @DisplayName("입력받은 다리가 비정상값으로 들어올 경우")
    @ParameterizedTest
    @MethodSource("inputWrongBridge")
    public void fail(List<String> value) {
        assertThatThrownBy(() -> new ValidateBridgeGame().validate(value))
                .isInstanceOf(IllegalStateException.class);
    }

    static Stream<Arguments> inputWrongBridge() {
        return Stream.of(
                Arguments.arguments(Arrays.asList("U", "d", "U", "d")),
                Arguments.arguments(Arrays.asList("u", "D", "U", "D")),
                Arguments.arguments(Arrays.asList("U", "D", "d")),
                Arguments.arguments(Arrays.asList("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "u")),
                Arguments.arguments(Arrays.asList("D", "D", "A", "D"))
        );
    }


}

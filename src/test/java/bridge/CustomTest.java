package bridge;

import bridge.Util.VerificationUtil;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이로 숫자 이외의 값이 들어오면 예외처리")
    @ValueSource(strings = {"H", "i", "!"})
    @ParameterizedTest
    void bridgeSize_numeric_test(String strings) {
        assertThatThrownBy(() -> VerificationUtil.verifyNumeric(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3 이상 20 이하에 속하지 않는 경우 예외처리")
    @ValueSource(strings = {"-1", "0", "2", "21", "100"})
    @ParameterizedTest
    void bridgeSize_range_test(String strings) {
        assertSimpleTest(() -> {
            runException(strings);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동할 칸 입력이 U 또는 D가 아닌 경우 예외처리")
    @ValueSource(strings = {"u", "d", "H", "i", ""})
    @ParameterizedTest
    void moving_test(String strings) {
        assertThatThrownBy(() -> VerificationUtil.verifyMoving(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}

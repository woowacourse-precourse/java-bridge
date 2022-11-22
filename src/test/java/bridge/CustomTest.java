package bridge;

import bridge.Util.VerificationUtil;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String GAME_RESULT = "최종 게임 결과";

    @DisplayName("다리 길이로 숫자 이외의 값이 들어오면 예외처리")
    @ValueSource(strings = {"H", "i", "!", ""})
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

    @DisplayName("사용자가 잘못된 다리 값을 입력할 경우 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다")
    @Test
    void reenter_bridgeSize_test() {
        assertRandomNumberInRangeTest(() -> {
            run("a", "1", "3", "U", "D", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    GAME_RESULT
            );
        }, 1, 0, 1);
    }

    @DisplayName("이동할 칸 입력이 U 또는 D가 아닌 경우 예외처리")
    @ValueSource(strings = {"u", "d", "H", "i", ""})
    @ParameterizedTest
    void moving_test(String strings) {
        assertThatThrownBy(() -> VerificationUtil.verifyMoving(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 이동할 칸을 잘못 입력할 경우 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다")
    @Test
    void reenter_moving_test() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "a", "U", "1", "D", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    GAME_RESULT
            );
        }, 1, 0, 1);
    }

    @DisplayName("게임 재시작/종료 여부 입력이 R 또는 Q가 아닌 경우 예외처리")
    @ValueSource(strings = {"r", "q", "H", "i", ""})
    @ParameterizedTest
    void command_test(String strings) {
        assertThatThrownBy(() -> VerificationUtil.verifyGameCommand(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 재시작 여부를 잘못 입력할 경우 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다")
    @Test
    void reenter_command_test() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "r", "Q");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    GAME_RESULT
            );
        }, 1, 0, 1);
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

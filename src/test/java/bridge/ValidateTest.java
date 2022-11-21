package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.utils.BridgeNumberGenerator;
import bridge.view.message.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest extends NsTest {

    @DisplayName("재시도 시 잘못된 문자열을 입력한 경우 예외를 출력한다.")
    @Test
    void 재시도_시_잘못된_문자열_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "S");
            assertThat(output()).contains(ErrorMessage.VALIDATE_GAME_RETRY);
        }, 1, 0, 0);

        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "T");
            assertThat(output()).contains(ErrorMessage.VALIDATE_GAME_RETRY);
        }, 1, 0, 0);
    }

    @DisplayName("첫 시작 시 다리의 길이를 정수가 아닌 값 입력 시 예외를 출력한다.")
    @Test
    void 다리의_길이_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("1.4");
            assertThat(output()).contains(ErrorMessage.VALIDATE_INTEGER_TYPE);
        }, 1);

        assertRandomNumberInRangeTest(() -> {
            run("ㅇㅇ");
            assertThat(output()).contains(ErrorMessage.VALIDATE_INTEGER_TYPE);
        }, 1);
    }

    @DisplayName("첫 시작 시 다리의 길이가 범위내 값이 아닌 경우 예외를 출력한다.")
    @Test
    void 다리의_길이_범위_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("2");
            assertThat(output()).contains(ErrorMessage.VALIDATE_BRIDGE_RANGE);
        }, 1);

        assertRandomNumberInRangeTest(() -> {
            run("90");
            assertThat(output()).contains(ErrorMessage.VALIDATE_BRIDGE_RANGE);
        }, 1);
    }

    @DisplayName("다리 이동 시 잘못된 문자열을 입력한 경우 예외를 출력한다.")
    @Test
    void 다리_이동_문자열_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "S");
            assertThat(output()).contains(ErrorMessage.VALIDATE_BRIDGE_MOVE);
        }, 1, 0, 0);

        assertRandomNumberInRangeTest(() -> {
            run("3", "ABC");
            assertThat(output()).contains(ErrorMessage.VALIDATE_BRIDGE_MOVE);
        }, 1, 0, 0);
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

package bridge;

import bridge.view.message.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateTest extends NsTest {

    @DisplayName("올바르지 않은 다리 이동 문자열인 경우 예외를 출력한다.")
    void 다리_이동_문자열_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "Q");
            assertThat(output()).contains(ErrorMessage.INPUT_MOVE_TYPE_ERROR);
        }, 1, 0, 0);

        assertRandomNumberInRangeTest(() -> {
            run("3", "C");
            assertThat(output()).contains(ErrorMessage.INPUT_MOVE_TYPE_ERROR);
        }, 1, 0, 0);
    }

    @DisplayName("다리의 길이가 정수가 아닌 값일 경우 예외를 출력한다.")
    @Test
    void 다리의_길이_입력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("0.1");
            assertThat(output()).contains(ErrorMessage.VALIDATE_INTEGER_TYPE_ERROR);
        }, 1);

        assertRandomNumberInRangeTest(() -> {
            run("ㅎㅇ");
            assertThat(output()).contains(ErrorMessage.VALIDATE_INTEGER_TYPE_ERROR);
        }, 1);
    }

    @DisplayName("다리의 길이가 3 이상 20 이하의 값이 아닌 경우 예외를 출력한다.")
    @Test
    void 다리의_길이_범위_입력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("0");
            assertThat(output()).contains(ErrorMessage.INPUT_NUMBER_RANGE_ERROR);
        }, 1);

        assertRandomNumberInRangeTest(() -> {
            run("1000");
            assertThat(output()).contains(ErrorMessage.INPUT_NUMBER_RANGE_ERROR);
        }, 1);
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

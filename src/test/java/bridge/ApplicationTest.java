package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.exception.Exception;
import bridge.utils.Validator;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 값에 문자가 포함되어 있을 시 예외를 발생시킨다.")
    @Test
    void 문자_테스트(){
        assertThatThrownBy(() -> Exception.checkString("1004j"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력 받은 문자열이 U혹은 D가 아닐 시 예외를 발생시킨다.")
    @Test
    void 문자_테스트_UD예외(){
        String input = "Q";
        assertThatThrownBy(() -> Exception.checkMove(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 문자열이 R혹은 Q가 아닐 시 예외를 발생시킨다.")
    @Test
    void 문자_테스트_RQ예외(){
        String input = "D";
        assertThatThrownBy(() -> Exception.checkRestartOrQuit(input))
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

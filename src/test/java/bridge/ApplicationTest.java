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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("다리 길이는 3부터 20 사이의 숫자여야 합니다")
    @ValueSource(strings = {"", "QR", "q", "r", "!", "1", "2", "2.9", "31"})
    @ParameterizedTest
    void 다리_길이_예외_테스트(String input) {
        assertThatThrownBy(() -> new BridgeGame().checkBridgeLenCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_정상_테스트() {
        assertThat(new BridgeGame().checkBridgeLenCommand("3")).isEqualTo(3);
        assertThat(new BridgeGame().checkBridgeLenCommand("20")).isEqualTo(20);
    }

    @DisplayName("Q, R 이외의 재시작 입력에 대한 예외 처리")
    @ValueSource(strings = {"", "QR", "q", "r", "!"})
    @ParameterizedTest
    void 재시도_예외_테스트(String input) {
        assertThatThrownBy(() -> new BridgeGame().checkGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시도_정상_테스트() {
        assertThat(new BridgeGame().checkGameCommand("R")).isTrue();
        assertThat(new BridgeGame().checkGameCommand("Q")).isFalse();
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

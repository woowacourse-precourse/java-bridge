package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "-", "s"})
    void 다리_길이_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "3", "A"})
    void 이동할_칸_예외_테스트(String input) {
        assertThatThrownBy(() -> ValidateInput.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:O", "1:X"}, delimiter = ':')
    void 이동_테스트(int position, StringBuilder expected) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(numberGenerator).makeBridge(4), position, true);
        bridgeGame.move("U");
        assertThat(bridgeGame.mapMaker.getMap()[0]).contains(expected);
    }

    @Test
    void 성공_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "D", "D", "U", "U", "D");
            assertThat(output()).contains("결과", "성공");
        }, 0, 0, 1, 1, 0);
    }

    @Test
    void 실패_재시작_종료_여부_질문_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "D", "Q");
            assertThat(output()).contains("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        }, 0, 0, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "-", "2"})
    void 재시작_종료_여부_예외_테스트(String input) {
        assertThatThrownBy(() -> ValidateInput.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
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
